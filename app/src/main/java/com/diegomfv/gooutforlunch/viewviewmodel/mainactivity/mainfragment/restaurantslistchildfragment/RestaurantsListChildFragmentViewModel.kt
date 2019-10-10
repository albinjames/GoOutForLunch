package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.restaurantslistchildfragment

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegomfv.gooutforlunch.data.model.domainmodel.restaurant.RestaurantModel
import com.diegomfv.gooutforlunch.utils.GlobalVariables
import com.diegomfv.gooutforlunch.utils.extensions.execute
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseViewModel
import io.reactivex.Observable

class RestaurantsListChildFragmentViewModel (val app: Application) : BaseViewModel(app) {

    val listOfRestaurantsLiveData = MutableLiveData<List<RestaurantModel>>()

    init {
       getData()
    }

    //TODO Substitute for real data, get from Server
    fun getData () {
        val list = mutableListOf(
            RestaurantModel.empty().apply {
                this.name = "Restaurant 1"
                this.address = "5th Avenue"
                this.type = "Japanese"
                this.openTime = "12.00h"
                this.closeTime = "22.00h"
                this.rating = 4.5f
            },
            RestaurantModel.empty().apply {
                this.name = "Restaurant 2"
                this.address = "4th Avenue"
                this.type = "Italian"
                this.openTime = "10.00h"
                this.closeTime = "23.00h"
                this.rating = 5.0f
            }
        )

        Observable.just(list)
            .execute(compositeDisposable,
                GlobalVariables.progressBarLiveData,
                { n->
                    listOfRestaurantsLiveData.value = list
                })
    }


    class Factory(private val app: Application) :
        ViewModelProvider.AndroidViewModelFactory(app) {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return RestaurantsListChildFragmentViewModel(app) as T
        }
    }

}