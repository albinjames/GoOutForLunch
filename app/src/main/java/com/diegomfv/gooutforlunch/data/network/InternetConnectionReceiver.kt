package com.diegomfv.gooutforlunch.data.network

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.diegomfv.gooutforlunch.utils.extensions.execute
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class InternetConnectionReceiver @Inject constructor() : BroadcastReceiver() {

    @Inject
    lateinit var internetMonitorTool: InternetMonitorTool

    override fun onReceive(context: Context?, intent: Intent?) {
        AndroidInjection.inject(this, context)
        internetMonitorTool.isInternetAvailableRx()
            .execute(
                CompositeDisposable(),
                {
                    //                    notifyAllListeners(it)
                },
                {},
                {})
    }
}
