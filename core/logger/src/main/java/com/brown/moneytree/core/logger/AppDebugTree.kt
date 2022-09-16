package com.brown.moneytree.core.logger

import android.os.Build
import timber.log.Timber
import java.util.regex.Pattern

internal class AppDebugTree : Timber.DebugTree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, createClassTag(), message, t)
    }

    private fun createClassTag(): String {
        val stackTrace = Throwable().stackTrace
        if (stackTrace.size <= CALL_STACK_INDEX) {
            throw IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?")
        }

        var tag = stackTrace[CALL_STACK_INDEX].className
        val m = ANONYMOUS_CLASS.matcher(tag)
        if (m.find()) {
            tag = m.replaceAll("")
        }
        tag = tag.substring(tag.lastIndexOf('.') + 1)
        // Tag length limit was removed in API 24.
        return when {
            Build.VERSION.SDK_INT >= 24 || tag.length <= MAX_TAG_LENGTH -> tag
            else -> tag.substring(0, MAX_TAG_LENGTH)
        }
    }

    companion object {
        private const val MAX_TAG_LENGTH = 23
        private const val CALL_STACK_INDEX = 6
        private val ANONYMOUS_CLASS by lazy { Pattern.compile("(\\$\\d+)+$") }
    }
}
