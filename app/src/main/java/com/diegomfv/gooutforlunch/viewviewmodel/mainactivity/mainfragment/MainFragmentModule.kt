package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment

import android.app.Application
import androidx.fragment.app.Fragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment.LoginCreateUserChildFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment.LoginCreateUserChildFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment.LoginMainChildFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.loginmainfragment.LoginMainChildFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.coworkerslistchildfragment.CoworkersListChildFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.coworkerslistchildfragment.CoworkersListChildFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.mapchildfragment.MapChildFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.mapchildfragment.MapChildFragmentModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.mapchildfragment.MapChildFragmentViewModel
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.restaurantslistchildfragment.RestaurantsListChildFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.restaurantslistchildfragment.RestaurantsListChildFragmentModule
import com.diegomfv.refractaticket.di.scope.PerChildFragment
import com.diegomfv.refractaticket.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module(includes = [BaseFragmentModule::class])
abstract class MainFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract fun fragment(mainFragment: MainFragment): Fragment

    @PerChildFragment
    @ContributesAndroidInjector(modules = [CoworkersListChildFragmentModule::class])
    abstract fun coworkersListChildFragmentInjector () : CoworkersListChildFragment

    @PerChildFragment
    @ContributesAndroidInjector(modules = [MapChildFragmentModule::class])
    abstract fun mapChildFragmentInjector () : MapChildFragment

    @PerChildFragment
    @ContributesAndroidInjector(modules = [RestaurantsListChildFragmentModule::class])
    abstract fun restaurantListChildFragmentInjector () : RestaurantsListChildFragment

    @Module
    companion object {

        @PerFragment
        @Provides
        @JvmStatic
        fun provideViewModelFactory(app: Application): MainFragmentViewModel.Factory {
            return MainFragmentViewModel.Factory(app)
        }
    }

}