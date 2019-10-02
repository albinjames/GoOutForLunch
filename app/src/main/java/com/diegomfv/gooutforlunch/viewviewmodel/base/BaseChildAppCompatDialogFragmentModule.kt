package com.diegomfv.gooutforlunch.viewviewmodel.base

import dagger.Module

@Module
class BaseChildAppCompatDialogFragmentModule {

    @Module
    companion object {
        const val FRAGMENT = "BaseChildAppCompatDialogFragmentModule.fragment"

        private const val CHILD_FRAGMENT_MANAGER = "BaseChildAppCompatDialogFragmentModule.childFragmentManager"

//        @JvmStatic
//        @Provides
//        @Named(CHILD_FRAGMENT_MANAGER)
//        @PerChildDialogFragment
//        fun childChildFragmentManager(@Named(FRAGMENT) fragment: Fragment): FragmentManager =
//            fragment.childFragmentManager
    }
}