package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.restaurantslistchildfragment

import android.app.Application
import androidx.fragment.app.Fragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseChildFragmentModule
import com.diegomfv.refractaticket.di.scope.PerChildFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module(includes = [BaseChildFragmentModule::class])
abstract class RestaurantsListChildFragmentModule {

    @Binds
    @Named(BaseChildFragmentModule.FRAGMENT)
    @PerChildFragment
    abstract fun fragment(restaurantsListChildFragment: RestaurantsListChildFragment): Fragment

    @Module
    companion object {

        @PerChildFragment
        @Provides
        @JvmStatic
        fun provideViewModelFactory(app: Application): RestaurantsListChildFragmentViewModel.Factory {
            return RestaurantsListChildFragmentViewModel.Factory(app)
        }
    }
}