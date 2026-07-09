package com.kiosk.browser

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.webkit.WebView

class NoZoomWebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {

    private var startX = 0f
    private var startY = 0f
    private var isZooming = false

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
                isZooming = false
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                // 多指触摸，可能是缩放
                isZooming = true
            }
            MotionEvent.ACTION_MOVE -> {
                if (event.pointerCount >= 2) {
                    // 检测是否为缩放手势
                    isZooming = true
                }
                if (isZooming) {
                    return true // 消费掉缩放手势，不传递给WebView
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                isZooming = false
            }
        }
        return super.onTouchEvent(event)
    }
}
