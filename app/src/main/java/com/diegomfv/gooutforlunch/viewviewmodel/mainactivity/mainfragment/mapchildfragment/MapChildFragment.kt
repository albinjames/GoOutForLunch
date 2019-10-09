package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.mapchildfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.logSimple
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment.LoginMainChildFragment

class MapChildFragment : BaseFragment() {

    lateinit var mainView: View

    companion object {
        fun newInstance () : MapChildFragment {
            val bundle = Bundle()
            val fragment = MapChildFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainView = inflater.inflate(R.layout.child_fragment_map, container, false)
        subscribeToModel()
        return mainView
    }



    override fun subscribeToModel() {

    }
}