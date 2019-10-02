package com.diegomfv.gooutforlunch.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.Window
import android.view.WindowManager

object Utils {

    fun getScreenWidth() = Resources.getSystem().displayMetrics.widthPixels.toFloat()

    fun getScreenHeight() = Resources.getSystem().displayMetrics.heightPixels.toFloat()

    fun dpToPixel(dp: Float): Float {
        val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
        val px = dp * (metrics.densityDpi / 160f)
        return Math.round(px).toFloat()
    }

    fun hideStatusBar (window: Window) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }



}