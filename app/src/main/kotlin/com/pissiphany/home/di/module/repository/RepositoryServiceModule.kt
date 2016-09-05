package com.pissiphany.home.di.module.repository

import com.pissiphany.home.domain.DataService
import com.pissiphany.home.data.ThemisApiV2RetrofitService
import com.pissiphany.home.data.ThemisApiV2Service
import com.pissiphany.home.data.buildService
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by kierse on 2016-08-31.
 */
@Module
class RepositoryServiceModule {
    @Provides
    fun provideThemisApiV2RetrofitService(@Named("url") url: String, @Named("token") token: String)
            : ThemisApiV2RetrofitService = buildService(url, token)

    @Provides
    @Named("api")
    fun provideRepositoryService(service: ThemisApiV2RetrofitService)
            : DataService = ThemisApiV2Service(service)
}