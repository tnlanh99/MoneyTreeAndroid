package com.brown.moneytree

import android.app.Application
import com.brown.moneytree.core.logger.Logger
import com.brown.moneytree.initializer.AppInitializer
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    internal lateinit var appInitializer: AppInitializer

    @Inject
    internal lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        appInitializer.init(this)
        logger.d("onCreate")
    }
}
