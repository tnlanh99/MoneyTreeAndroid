@file:Suppress("unused")

package com.brown.moneytree.core.common.extension

import android.graphics.Rect
import android.view.View
import androidx.core.view.isVisible

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

inline var View.beShown: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        isVisible
        visibility = if (value) View.VISIBLE else View.INVISIBLE
    }

inline fun View.doOnPost(
    crossinline action: (View) -> Unit
) {
    post {
        action.invoke(this)
    }
}

fun View.getLocationOnScreen(): IntArray {
    val location = IntArray(2)
    this.getLocationOnScreen(location)
    return location
}

fun View.getDrawingRectOnScreen(): Rect {
    val location = IntArray(2)
    val outRect = Rect()
    this.getDrawingRect(outRect)
    this.getLocationOnScreen(location)
    outRect.offset(location[0], location[1])
    outRect.right = (outRect.left + outRect.width() * scaleX).toInt()
    outRect.bottom = (outRect.top + outRect.height() * scaleY).toInt()
    return outRect
}
