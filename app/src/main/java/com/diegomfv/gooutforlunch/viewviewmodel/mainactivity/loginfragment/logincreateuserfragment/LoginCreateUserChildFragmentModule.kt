package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment

import android.app.Application
import androidx.fragment.app.Fragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseChildFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment.LoginMainChildFragmentViewModel
import com.diegomfv.refractaticket.di.scope.PerChildFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module(includes = [BaseChildFragmentModule::class])
abstract class LoginCreateUserChildFragmentModule {

    @Binds
    @Named(BaseChildFragmentModule.FRAGMENT)
    @PerChildFragment
    abstract fun fragment(loginCreateUserChildFragment: LoginCreateUserChildFragment): Fragment

    @Module
    companion object {

        @PerChildFragment
        @Provides
        @JvmStatic
        fun provideViewModelFactory(app: Application): LoginCreateUserChildFragmentViewModel.Factory {
            return LoginCreateUserChildFragmentViewModel.Factory(app)
        }
    }

}