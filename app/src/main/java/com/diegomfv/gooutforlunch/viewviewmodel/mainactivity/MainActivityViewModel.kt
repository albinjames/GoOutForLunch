package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseViewModel

class MainActivityViewModel(
    private val app: Application
) : BaseViewModel(app) {




    class Factory(private val app: Application) :
        ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainActivityViewModel(app) as T
        }
    }

}

