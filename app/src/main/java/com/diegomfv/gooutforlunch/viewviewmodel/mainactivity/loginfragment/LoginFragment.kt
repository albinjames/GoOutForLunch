package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.logSimple
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment.LoginMainChildFragment

class LoginFragment : BaseFragment() {

    lateinit var mainView: View

    companion object {

        fun newInstance () : LoginFragment {
            val bundle = Bundle()
            val fragment = LoginFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logSimple("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logSimple("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logSimple("onCreateView")
        mainView = inflater.inflate(R.layout.fragment_login, container, false)

        if (savedInstanceState == null) {

            childFragmentManager.beginTransaction()
                .replace(R.id.child_fragment_container, LoginMainChildFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logSimple("onViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        logSimple("onViewStateRestored")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logSimple("onActivityCreated")
    }

    override fun subscribeToModel() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}