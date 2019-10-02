package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment

import androidx.fragment.app.Fragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseFragmentModule
import com.diegomfv.refractaticket.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module(includes = [BaseFragmentModule::class])
abstract class LoginFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract fun fragment(loginFragment: LoginFragment): Fragment

}