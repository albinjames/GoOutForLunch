package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseViewModel

class LoginFragmentViewModel(val app: Application) : BaseViewModel(app) {

    class Factory(private val app: Application) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginFragmentViewModel(app) as T
        }
    }

}

