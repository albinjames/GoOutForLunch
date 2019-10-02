package com.diegomfv.gooutforlunch.viewviewmodel.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.diegomfv.refractaticket.di.scope.PerFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class BaseFragmentModule {

    @Module
    companion object {
        const val FRAGMENT = "BaseFragmentModule.fragment"

        private const val CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager"

        @JvmStatic
        @Provides
        @Named(CHILD_FRAGMENT_MANAGER)
        @PerFragment
        fun childFragmentManager(@Named(FRAGMENT) fragment: Fragment): FragmentManager =
            fragment.childFragmentManager
    }
}