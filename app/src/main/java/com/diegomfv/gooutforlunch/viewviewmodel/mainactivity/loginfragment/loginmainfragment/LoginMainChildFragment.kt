package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.applicationprovider.ApplicationResourceProvider
import com.diegomfv.gooutforlunch.utils.customview.LoginBlock
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.MainActivityViewModel
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.LoginFragmentViewModel
import com.jakewharton.rxbinding3.widget.textChanges

class LoginMainChildFragment : BaseFragment() {

    lateinit var mainView: View
    lateinit var emailBlock: LoginBlock
    lateinit var passwordBlock: LoginBlock

    lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var loginFragmentViewModel: LoginFragmentViewModel
    lateinit var loginMainChildFragmentViewModel: LoginMainChildFragmentViewModel

    companion object {

        fun newInstance () : LoginMainChildFragment {
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
        passwordBlock.getTextInputLayout().hint = ApplicationResourceProvider.getString(R.string.password)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
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
            .map {
                it.toString().trim()
            }
            .doOnSubscribe { vCompositeDisposable.add(it) }
            .subscribe { text ->
                println(text)
            }

        passwordBlock.getEditText()
            .textChanges()
            .map {
                it.toString().trim()
            }
            .doOnSubscribe { vCompositeDisposable.add(it) }
            .subscribe { text ->
                println(text)
            }
    }

    override fun subscribeToModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}