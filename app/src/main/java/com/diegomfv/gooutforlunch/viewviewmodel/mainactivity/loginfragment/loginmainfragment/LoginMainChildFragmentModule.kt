package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment

import android.app.Application
import androidx.fragment.app.Fragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseChildFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.LoginFragmentViewModel
import com.diegomfv.refractaticket.di.scope.PerChildFragment
import com.diegomfv.refractaticket.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [BaseChildFragmentModule::class])
abstract class LoginMainChildFragmentModule {

    @Binds
    @Named(BaseChildFragmentModule.FRAGMENT)
    @PerChildFragment
    abstract fun fragment(loginMainChildFragment: LoginMainChildFragment): Fragment

    @Module
    companion object {

        @PerChildFragment
        @Provides
        @JvmStatic
        fun provideViewModelFactory(app: Application): LoginMainChildFragmentViewModel.Factory {
            return LoginMainChildFragmentViewModel.Factory(app)
        }
    }


}