package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.diegomfv.gooutforlunch.R
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
//        mainView = inflater.inflate(R.layout.child_fragment_login_main, container, false)
//        return mainView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        subscribeToModel()
        super.onActivityCreated(savedInstanceState)
    }

    override fun subscribeToModel() {
        loginCreateUserChildFragmentViewModel = ViewModelProviders.of(this, factory).get(LoginCreateUserChildFragmentViewModel::class.java)
    }
}