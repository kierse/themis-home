package com.pissiphany.home.di.module

import android.content.Context
import com.pissiphany.home.App
import com.pissiphany.home.HomeApp
import dagger.Module
import dagger.Provides
import rx.Scheduler
import javax.inject.Named

/**
 * Created by kierse on 2016-08-31.
 */
@Module
class AppModule(
        private val app: App,
        private val scheduler: Scheduler,
        private val url: String,
        private val token: String
) {
    @Provides
    fun provideApp() : HomeApp = app

    @Provides
    fun provideContext() : Context = app.applicationContext

    @Provides
    fun provideScheduler() : Scheduler = scheduler

    @Provides
    @Named("url")
    fun provideUrl() : String = url

    @Provides
    @Named("token")
    fun provideToken() : String = token
}