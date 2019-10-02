package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment

import android.os.Bundle
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment

class LoginCreateUserChildFragment : BaseFragment() {

    companion object {

        fun newInstance(): LoginCreateUserChildFragment {
            val bundle = Bundle()
            val fragment = LoginCreateUserChildFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun subscribeToModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}