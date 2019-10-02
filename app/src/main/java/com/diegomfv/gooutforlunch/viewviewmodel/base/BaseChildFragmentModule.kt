package com.diegomfv.gooutforlunch.viewviewmodel.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.diegomfv.refractaticket.di.scope.PerFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BaseChildFragmentModule {

    @Module
    companion object {
        const val FRAGMENT = "BaseChildFragmentModule.fragment"

        private const val CHILD_FRAGMENT_MANAGER = "BaseChildFragmentModule.childFragmentManager"

        @JvmStatic
        @Provides
        @Named(CHILD_FRAGMENT_MANAGER)
        @PerFragment
        fun childChildFragmentManager(@Named(FRAGMENT) fragment: Fragment): FragmentManager =
            fragment.childFragmentManager
    }
}