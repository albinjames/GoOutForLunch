package com.diegomfv.gooutforlunch.di.module

import android.content.IntentFilter
import com.diegomfv.gooutforlunch.utils.CONNECTIVITY_INTENT_FILTER
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UtilsModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideInternetConnectivityIntentFilter() : IntentFilter {
            return IntentFilter(CONNECTIVITY_INTENT_FILTER)
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideGson() : Gson {
            return Gson()
        }
    }

}