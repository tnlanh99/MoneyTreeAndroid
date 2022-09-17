package com.brown.moneytree.initializer

import android.app.Application
import com.brown.moneytree.core.common.Initializable
import javax.inject.Inject

class AppInitializer @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards Initializable>
) {

    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}
