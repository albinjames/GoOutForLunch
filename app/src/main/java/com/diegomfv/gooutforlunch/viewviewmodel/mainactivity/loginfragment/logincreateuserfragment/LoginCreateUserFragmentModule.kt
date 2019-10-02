package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.logincreateuserfragment

import androidx.fragment.app.Fragment
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseChildFragmentModule
import com.diegomfv.refractaticket.di.scope.PerChildFragment
import dagger.Binds
import dagger.Module
import javax.inject.Named


@Module(includes = [BaseChildFragmentModule::class])
abstract class LoginCreateUserFragmentModule {

    @Binds
    @Named(BaseChildFragmentModule.FRAGMENT)
    @PerChildFragment
    abstract fun fragment(loginCreateUserFragment: LoginCreateUserFragment): Fragment

}