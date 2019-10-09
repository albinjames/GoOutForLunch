package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.mainfragment.mapchildfragment

import android.app.Application
import androidx.fragment.app.Fragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseChildFragmentModule
import com.diegomfv.refractaticket.di.scope.PerChildFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [BaseChildFragmentModule::class])
abstract class MapChildFragmentModule {

    @Binds
    @Named(BaseChildFragmentModule.FRAGMENT)
    @PerChildFragment
    abstract fun fragment(mapChildFragment: MapChildFragment): Fragment

    @Module
    companion object {

        @PerChildFragment
        @Provides
        @JvmStatic
        fun provideViewModelFactory(app: Application): MapChildFragmentViewModel.Factory {
            return MapChildFragmentViewModel.Factory(app)
        }
    }




}