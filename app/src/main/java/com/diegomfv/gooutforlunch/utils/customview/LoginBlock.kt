package com.diegomfv.gooutforlunch.utils.customview

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.diegomfv.gooutforlunch.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginBlock : LinearLayout {

    private val DEFAULT_COLOR = Color.DKGRAY

    private lateinit var mPaint: Paint
    private lateinit var mRect: Rect

    lateinit var view: View

//    companion object {
//        private var labelColor: Int = Color.BLUE
//        private var editTextColor: Int = Color.DKGRAY
//        private var mPadding = 0
//        private val originX = 0
//        private val originY = 0
//    }

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    private fun init(set: AttributeSet?) {
        if (set == null) return

        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

//        val typedArray = context.obtainStyledAttributes(set, R.styleable.FillFormView)
//        labelColor = typedArray.getColor(R.styleable.FillFormView_label_color, DEFAULT_COLOR)
//        editTextColor =
//            typedArray.getColor(R.styleable.FillFormView_edittext_text_color, DEFAULT_COLOR)
////        mPaint.color = labelColor
//        typedArray.recycle()

        orientation = LinearLayout.VERTICAL

        view = inflate(context, R.layout.login_block_layout, null)
        addView(view)

    }

    fun getTextInputLayout () : TextInputLayout {
        return view.findViewById(R.id.login_block_layout)
    }

    fun getEditText () : TextInputEditText {
        return view.findViewById(R.id.login_block_edittext)
    }

//    fun swapColor() {
//        mPaint.color = if (mPaint.color == labelColor) Color.CYAN else labelColor
//        postInvalidate()
//    }

//    fun swapLabelColor() {
//        view.label_textview.setTextColor(context.getColor(R.color.design_default_color_primary))
////        mPaint.color = if (mPaint.color == labelColor) Color.CYAN else labelColor
//        postInvalidate()
//    }
//
//    fun swapEditTextColor() {
//        view.edittext.setTextColor(context.getColor(R.color.colorRedWarning))
////        mPaint.color = if (mPaint.color == labelColor) Color.CYAN else labelColor
//        postInvalidate()
//    }

//    fun paddingUp(padding: Int): Boolean {
//        if(isPaddingWithinBounds(mPadding + padding)) {
//            mPadding += padding
//            refresh()
//            return VIEW_CHANGED
//        }
//        return VIEW_NOT_CHANGED
//    }
//
//    fun paddingDown(padding: Int): Boolean {
//        if(isPaddingWithinBounds(mPadding - padding)) {
//            mPadding -= padding
//            refresh()
//            return VIEW_CHANGED
//        }
//        return VIEW_NOT_CHANGED
//    }

//    private fun isPaddingWithinBounds(padding: Int): Boolean {
//        return checkBoundsForPaddingUp(padding) && checkBoundsForPaddingDown(padding)
//    }
//
//    private fun checkBoundsForPaddingUp(padding: Int): Boolean {
//        return (originX + padding < width - padding) && (originY + padding < height - padding)
//    }
//
//    private fun checkBoundsForPaddingDown(padding: Int): Boolean {
//        return (padding > 0)
//    }

//    fun setMode(fillFormMode: FillFormMode) {
//        when (fillFormMode) {
//            is FillFormMode.TEXT_MODE -> makeViewWritable()
//            is FillFormMode.POP_UP_MODE -> makeViewShowable(fillFormMode.listener)
//        }
//    }
//
//    private fun makeViewShowable(l: OnClickListener?) {
//        view.overlay_frame.visibility = View.VISIBLE
//        view.overlay_frame.setOnClickListener(l)
//        view.edittext.isFocusable = false
//    }
//
//    private fun makeViewWritable() {
//        view.overlay_frame.visibility = View.GONE
//        view.overlay_frame.setOnClickListener(null)
//        view.edittext.isFocusable = true
//    }
//
//    fun updateError(errorMessage: String) {
//        if (view.error_message.text.isNullOrBlank()) {
//            view.error_message.text = errorMessage
//            view.error_message.visibility = View.VISIBLE
//
////            Animates the appearance
////            ObjectAnimator.ofFloat(view.error_message, "translationX", 100f).apply {
////                duration = 2000
////                start()
////            }
//
//
//            //TODO Change the values, they cannot be hardcoded
//
//            // Animates the appearance
//            ObjectAnimator.ofFloat(
//                view.error_message,
//                "translationX",
//                -separator.width.toFloat(),
//                0f
//            ).apply {
//                duration = 500
//                start()
//            }
//
//
//        } else {
//
//            ObjectAnimator.ofFloat(
//                view.error_message,
//                "translationX",
//                0f,
//                -separator.width.toFloat()
//            ).apply {
//                duration = 500
//                start()
//            }.doOnEnd {
//                view.error_message.text = ""
//                view.error_message.visibility = View.GONE
//            }
//        }
//    }
//
//    private fun refresh() {
//        postInvalidate()
//    }
//
//
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
////        setViewBounds()
////        canvas.drawRect(mRect, mPaint)
//    }
//
////    private fun setViewBounds() {
////        mRect.left = originX + mPadding
////        mRect.right = width - mPadding
////        mRect.top = originY + mPadding
////        mRect.bottom = height - mPadding
////    }
//
//    sealed class FillFormMode {
//        object TEXT_MODE : FillFormMode()
//        class POP_UP_MODE(var listener: OnClickListener? = null) : FillFormMode()
//
//    }
}