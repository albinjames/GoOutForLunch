package com.diegomfv.gooutforlunch.di.module

import com.diegomfv.refractaticket.di.scope.PerBroadcastReceiver
import com.diegomfv.gooutforlunch.data.network.InternetConnectionReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BroadcastReceiverModule {

    @PerBroadcastReceiver
    @ContributesAndroidInjector
    abstract fun internetConnectionReceiverInjector () : InternetConnectionReceiver
}