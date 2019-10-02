package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.customview.LoginBlock
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment
import com.jakewharton.rxbinding3.widget.textChanges

class LoginMainChildFragment : BaseFragment() {

    lateinit var mainView: View
    lateinit var emailBlock: LoginBlock
    lateinit var passwordBlock: LoginBlock

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
        passwordBlock = mainView.findViewById(R.id.login_block_password)
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