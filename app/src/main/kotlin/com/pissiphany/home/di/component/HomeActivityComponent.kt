package com.pissiphany.home.di.component

import com.pissiphany.home.di.module.repository.DataServiceModule
import com.pissiphany.home.presenter.HomePresenter
import com.pissiphany.home.HomeActivity
import dagger.Component

/**
 * Created by kierse on 2016-08-31.
 */
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(DataServiceModule::class)
)
interface HomeActivityComponent {
    fun presenter() : HomePresenter

    fun inject(activity: HomeActivity)
}