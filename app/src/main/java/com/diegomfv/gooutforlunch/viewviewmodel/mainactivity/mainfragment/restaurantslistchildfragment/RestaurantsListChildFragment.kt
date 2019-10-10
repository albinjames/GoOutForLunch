package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.restaurantslistchildfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.extensions.shortToast
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseChildFragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragment
import kotlinx.android.synthetic.main.child_fragment_restaurants.*
import javax.inject.Inject

class RestaurantsListChildFragment : BaseChildFragment() {

    lateinit var restaurantsListChildFragmentViewModel: RestaurantsListChildFragmentViewModel

    lateinit var rvAdapter: RestaurantsListChildFragmentAdapter
    lateinit var mainView: View

    @Inject
    lateinit var factory: RestaurantsListChildFragmentViewModel.Factory

    val onCardClicked : (Int) -> Unit = { position: Int ->
        activity?.shortToast("Position clicked: $position")
    }

    companion object {
        fun newInstance () : RestaurantsListChildFragment {
            val bundle = Bundle()
            val fragment = RestaurantsListChildFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainView = inflater.inflate(R.layout.child_fragment_restaurants, container, false)
        subscribeToModel()
        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { activity ->
            recycler_view_restaurants.setHasFixedSize(true)
            recycler_view_restaurants.layoutManager = GridLayoutManager(activity, 2)
            rvAdapter = RestaurantsListChildFragmentAdapter(
                mutableListOf())
            rvAdapter.onCardClicked = onCardClicked
            recycler_view_restaurants.adapter = rvAdapter
        }
    }

    override fun subscribeToModel() {
        restaurantsListChildFragmentViewModel = ViewModelProviders.of(this, factory).get(RestaurantsListChildFragmentViewModel::class.java)

        restaurantsListChildFragmentViewModel.listOfRestaurantsLiveData.observe(this, Observer {
            rvAdapter.resetList(it)
        })

    }
}