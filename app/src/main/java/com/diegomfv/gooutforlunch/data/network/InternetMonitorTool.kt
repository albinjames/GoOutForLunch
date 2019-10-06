package com.diegomfv.gooutforlunch.data.network

import com.diegomfv.gooutforlunch.R
import com.diegomfv.gooutforlunch.utils.applicationprovider.ApplicationResourceProvider
import com.diegomfv.gooutforlunch.utils.logCurrentThread
import io.reactivex.Observable
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketException
import javax.inject.Inject
import javax.inject.Singleton

class InternetMonitorTool @Inject constructor() {

    fun isInternetAvailableRx(): Observable<Boolean> {
        return Observable.fromCallable {
            try {
                logCurrentThread("Checking internet connection")
                isInternetAvailable()
            } catch (e: SocketException) {
                throw Throwable(ApplicationResourceProvider.getString(R.string.internet_error_checking))
            } catch (e: Exception) {
                throw Throwable(e.message)
            }
        }
    }

    private fun isInternetAvailable(): Boolean {
        return try {
            val timeoutMs = 1500
            val sock = Socket()
            val sockAddress = InetSocketAddress("8.8.8.8", 53)
            sock.connect(sockAddress, timeoutMs)
            sock.close()
            true
        } catch (e: IOException) {
            false
        }
    }
}