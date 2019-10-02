package com.diegomfv.gooutforlunch.utils.extensions

import android.app.Activity
import android.app.Service
import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


fun Context.shortToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.longToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

fun FragmentActivity.startActivity(dest: FragmentActivity) = startActivity(Intent(this, dest::class.java))

fun FragmentActivity.startActivityClearingBackStack(dest: FragmentActivity) {
    val intent = Intent(this, dest::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
    finish()
}

fun Activity.hideKeyboard() = (getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager)
    .hideSoftInputFromWindow(currentFocus?.windowToken, 0)

fun Fragment.hideKeyboard(activity: Activity?) =
    (activity?.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(this.view?.windowToken, 0)


fun Fragment.showKeyboard(activity: Activity?) {
    val fragment = this
    (activity?.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager)
        .showSoftInputFromInputMethod(fragment.view?.windowToken, 0)
}

//fun Context.createSnackBar (connectivityMode: ConnectivityManager.ConnectivityMode, view: View): Snackbar {
//    return when (connectivityMode) {
//        ConnectivityManager.ConnectivityMode.ONLINE_MODE -> {
//            getSnackBarOnlineMode(this, view)
//        }
//        ConnectivityManager.ConnectivityMode.ONLY_INTERNET_MODE -> {
//            getSnackBarOnlyInternetMode(this, view)
//        }
//        ConnectivityManager.ConnectivityMode.OFFLINE_MODE -> {
//            getSnackBarOfflineMode(this, view)
//        }
//    }
//}