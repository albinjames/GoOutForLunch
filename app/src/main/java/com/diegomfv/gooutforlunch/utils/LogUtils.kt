package com.diegomfv.gooutforlunch.utils

import androidx.lifecycle.ViewModel
import timber.log.Timber

fun logCurrentThread(message: String = "") {
    Timber.i("THREAD_: ${Thread.currentThread()} // $message")
}

fun logSimple(message: String) {
    Timber.i("SIMPLE_LOG_: $message")
}

fun logWithTitle(title: String, message: String) {
    Timber.i("$title: $message")
}

fun logDatasnapshot (message: String) {
    Timber.i("DATASNAPSHOT__: $message")
}

fun logViewModel (viewModel: ViewModel, message: String = "") {
    Timber.i("VIEWMODEL__: ${viewModel::class.java.simpleName} // ${viewModel.hashCode()} // $message")
}