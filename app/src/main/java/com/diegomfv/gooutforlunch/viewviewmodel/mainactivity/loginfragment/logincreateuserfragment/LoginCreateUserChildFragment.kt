package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment
import javax.inject.Inject

class LoginCreateUserChildFragment : BaseFragment() {

    @Inject
    lateinit var factory : LoginCreateUserChildFragmentViewModel.Factory

    lateinit var loginCreateUserChildFragmentViewModel: LoginCreateUserChildFragmentViewModel

    companion object {

        fun newInstance(): LoginCreateUserChildFragment {
            val bundle = Bundle()
            val fragment = LoginCreateUserChildFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun subscribeToModel() {
        loginCreateUserChildFragmentViewModel = ViewModelProviders.of(this, factory).get(LoginCreateUserChildFragmentViewModel::class.java)
    }
}