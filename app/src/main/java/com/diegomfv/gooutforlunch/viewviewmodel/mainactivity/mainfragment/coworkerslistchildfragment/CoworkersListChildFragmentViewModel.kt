package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.coworkerslistchildfragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseViewModel
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.LoginFragmentViewModel

class CoworkersListChildFragmentViewModel (
    val app: Application
) : BaseViewModel(app) {

    class Factory(private val app: Application) :
        ViewModelProvider.AndroidViewModelFactory(app) {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CoworkersListChildFragmentViewModel(app) as T
        }
    }

}