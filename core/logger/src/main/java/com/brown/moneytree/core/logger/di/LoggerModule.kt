package com.brown.moneytree.core.logger.di

import com.brown.moneytree.core.common.Initializable
import com.brown.moneytree.core.logger.Logger
import com.brown.moneytree.core.logger.LoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
abstract class LoggerModule {

    @Binds
    abstract fun bindsLogger(logger: LoggerImpl): Logger

    @Binds
    @IntoSet
    abstract fun bindsLoggerInitializer(logger: LoggerImpl): Initializable
}
