package com.brown.moneytree

import android.app.Application
import com.brown.moneytree.core.logger.Logger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    internal lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        logger.setup(BuildConfig.DEBUG)
    }
}
