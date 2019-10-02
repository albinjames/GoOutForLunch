package com.diegomfv.gooutforlunch.utils.extensions

import android.animation.Animator
import android.view.View
import android.view.ViewGroup
import com.diegomfv.gooutforlunch.utils.enumutils.Duration
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

fun View.showCrossFadeAnimation(duration: Duration, listener: Animator.AnimatorListener? = null) {

    if (this != null) {
        this.alpha = 0f
        this.visibility = View.VISIBLE

        this.animate()
            .alpha(1f)
            .setDuration(duration.duration)
            .setListener(listener)
    }
}

fun View.hideCrossFadeAnimation(duration: Duration, listener: Animator.AnimatorListener? = null) {

    if (this != null) {
        this.alpha = 1f

        this.animate()
            .alpha(1f)
            .setDuration(duration.duration)
            .setListener(listener)

        this.visibility = View.INVISIBLE
    }
}

fun View.goneCrossFadeAnimation(duration: Duration, listener: Animator.AnimatorListener? = null) {

    if (this != null) {
        this.alpha = 1f

        this.animate()
            .alpha(1f)
            .setDuration(duration.duration)
            .setListener(listener)

        this.visibility = View.GONE
    }
}

fun View.getAllChildren(): ArrayList<View> {

    if (this !is ViewGroup) {
        val viewArrayList = ArrayList<View>()
        viewArrayList.add(this)
        return viewArrayList
    }

    val result = ArrayList<View>()

    for (i in 0 until this.childCount) {

        val child = this.getChildAt(i)

        val viewArrayList = ArrayList<View>()
        viewArrayList.add(this)
        viewArrayList.addAll(child.getAllChildren())

        result.addAll(viewArrayList)
    }
    return result
}

fun TextInputLayout.getTextInputEditText(): TextInputEditText? {
    val list = this.getAllChildren()
    list.forEach { if (it is TextInputEditText) return it }
    return null
}