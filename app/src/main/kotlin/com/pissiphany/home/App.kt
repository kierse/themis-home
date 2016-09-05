package com.pissiphany.home

import android.app.Application
import com.pissiphany.home.di.component.AppComponent
import com.pissiphany.home.di.component.DaggerAppComponent
import com.pissiphany.home.di.module.AppModule
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by kierse on 2016-08-31.
 */
class App : HomeApp, Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule(
                        this,
                        AndroidSchedulers.mainThread(),
                        resources.getString(R.string.themis_api_v2_root),
                        resources.getString(R.string.themis_api_oauth_token)
                ))
                .build()
    }

    override fun component(): AppComponent = component
}