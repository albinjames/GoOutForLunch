package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment

import android.app.Application
import androidx.fragment.app.Fragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.MainActivityViewModel
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment.LoginCreateUserChildFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment.LoginCreateUserChildFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment.LoginMainChildFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment.LoginMainChildFragmentModule
import com.diegomfv.refractaticket.di.scope.PerActivity
import com.diegomfv.refractaticket.di.scope.PerChildFragment
import com.diegomfv.refractaticket.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module(includes = [BaseFragmentModule::class])
abstract class LoginFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract fun fragment(loginFragment: LoginFragment): Fragment

    @PerChildFragment
    @ContributesAndroidInjector(modules = [LoginMainChildFragmentModule::class])
    abstract fun loginMainChildFragmentInjector () : LoginMainChildFragment

    @PerChildFragment
    @ContributesAndroidInjector(modules = [LoginCreateUserChildFragmentModule::class])
    abstract fun loginCreateUserChildFragmentInjector () : LoginCreateUserChildFragment

    @Module
    companion object {

        @PerFragment
        @Provides
        @JvmStatic
        fun provideViewModelFactory(app: Application): LoginFragmentViewModel.Factory {
            return LoginFragmentViewModel.Factory(app)
        }
    }

}