package com.pissiphany.home.di.component

import android.content.Context
import com.pissiphany.home.HomeApp
import com.pissiphany.home.di.module.AppModule
import dagger.Component
import rx.Scheduler
import javax.inject.Named

/**
 * Created by kierse on 2016-08-31.
 */
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun app() : HomeApp
    fun context() : Context
    fun scheduler() : Scheduler

    @Named("url")
    fun url() : String

    @Named("token")
    fun token() : String

    fun inject(app: HomeApp)
}