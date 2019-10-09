package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.mapchildfragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseViewModel
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.LoginFragmentViewModel

class MapChildFragmentViewModel (val app: Application) : BaseViewModel(app) {

    class Factory(private val app: Application) :
        ViewModelProvider.AndroidViewModelFactory(app) {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MapChildFragmentViewModel(app) as T
        }
    }


}


//@Module(includes = [BaseChildFragmentModule::class])
//abstract class LoginMainChildFragmentModule {
//
//    @Binds
//    @Named(BaseChildFragmentModule.FRAGMENT)
//    @PerChildFragment
//    abstract fun fragment(loginMainChildFragment: LoginMainChildFragment): Fragment
//
//    @Module
//    companion object {
//
//        @PerChildFragment
//        @Provides
//        @JvmStatic
//        fun provideViewModelFactory(app: Application, loginUseCase: LoginUseCase): LoginMainChildFragmentViewModel.Factory {
//            return LoginMainChildFragmentViewModel.Factory(app, loginUseCase)
//        }
//    }
//}