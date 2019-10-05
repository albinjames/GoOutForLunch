package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.applicationprovider.ApplicationResourceProvider
import com.diegomfv.gooutforlunch.utils.customview.LoginBlock
import com.diegomfv.gooutforlunch.utils.extensions.shortToast
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.MainActivity
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.child_fragment_login_main.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginMainChildFragment : BaseFragment() {

    @Inject
    lateinit var factory: LoginMainChildFragmentViewModel.Factory

    //    lateinit var mainActivityViewModel: MainActivityViewModel
//    lateinit var loginFragmentViewModel: LoginFragmentViewModel
    lateinit var loginMainChildFragmentViewModel: LoginMainChildFragmentViewModel

    lateinit var mainView: View
    lateinit var emailBlock: LoginBlock
    lateinit var passwordBlock: LoginBlock

    companion object {

        fun newInstance(): LoginMainChildFragment {
            val bundle = Bundle()
            val fragment = LoginMainChildFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainView = inflater.inflate(R.layout.child_fragment_login_main, container, false)
        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emailBlock = mainView.findViewById(R.id.login_block_email)
        emailBlock.getTextInputLayout().hint = ApplicationResourceProvider.getString(R.string.email)
        passwordBlock = mainView.findViewById(R.id.login_block_password)
        passwordBlock.getTextInputLayout().hint =
            ApplicationResourceProvider.getString(R.string.password)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        subscribeToModel()
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        bindViews()
    }

    @SuppressLint("CheckResult")
    fun bindViews() {
        emailBlock.getEditText()
            .textChanges()
            .skipInitialValue()
            .debounce(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.toString().trim()
            }
            .doOnSubscribe { vCompositeDisposable.add(it) }
            .subscribe { text ->
                println("email in rxBinding $text")
                loginMainChildFragmentViewModel.emailLiveData.value = text
            }

        passwordBlock.getEditText()
            .textChanges()
            .skipInitialValue()
            .debounce(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.toString().trim()
            }
            .doOnSubscribe { vCompositeDisposable.add(it) }
            .subscribe { text ->
                println("password in rxBinding $text")
                loginMainChildFragmentViewModel.passwordLiveData.value = text
            }

        sign_in_button.clicks()
            .throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                loginMainChildFragmentViewModel.login()
            }
    }

    override fun subscribeToModel() {
        loginMainChildFragmentViewModel =
            ViewModelProviders.of(this, factory).get(LoginMainChildFragmentViewModel::class.java)

        loginMainChildFragmentViewModel.loginSuccessfulLiveData.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                activity?.let {
                    it.shortToast("Login completed successfully")
//                    val i = Intent(it, MainActivity::class.java)
//                    startActivity(i)

                }
            }
        })

        //TODO Not working. Find a way to make RxBindings and LiveData work together
        loginMainChildFragmentViewModel.emailLiveData.observe(this, Observer {
            println("email $it")
            emailBlock.getEditText().text?.let {
                if(it.isBlank()) emailBlock.getEditText().setText(it)
            }
        })

        loginMainChildFragmentViewModel.passwordLiveData.observe(this, Observer {
            println("password $it")
            passwordBlock.getEditText().text?.let {
                if(it.isBlank()) passwordBlock.getEditText().setText(it)
            }
        })
    }
}