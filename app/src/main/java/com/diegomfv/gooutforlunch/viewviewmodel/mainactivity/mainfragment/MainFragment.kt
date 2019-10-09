package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.logSimple
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.mapchildfragment.MapChildFragment
import javax.inject.Inject

class MainFragment: BaseFragment() {

    @Inject
    lateinit var factory: MainFragmentViewModel.Factory

    lateinit var mainFragmentViewModel: MainFragmentViewModel

    lateinit var mainView: View

    companion object {
        fun newInstance () : MainFragment {
            val bundle = Bundle()
            val fragment = MainFragment()
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        logSimple("onCreateView")
        mainView = inflater.inflate(R.layout.fragment_main, container, false)
        subscribeToModel()

        if (savedInstanceState == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.child_fragment_container, MapChildFragment.newInstance())
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
        mainFragmentViewModel = ViewModelProviders.of(this, factory).get(MainFragmentViewModel::class.java)
    }
}