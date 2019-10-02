package com.diegomfv.gooutforlunch.di

import com.diegomfv.gooutforlunch.App
import com.diegomfv.gooutforlunch.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Factory : AndroidInjector.Builder<App>()

}