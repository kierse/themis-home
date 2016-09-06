package com.pissiphany.home.di.module.repository

import com.pissiphany.home.domain.service.data.MatterDataService
import com.pissiphany.home.data.ThemisApiV2RetrofitService
import com.pissiphany.home.data.service.data.ThemisApiV2MatterDataService
import com.pissiphany.home.data.buildService
import com.pissiphany.home.data.service.data.ThemisApiV2CalendarEntryDataService
import com.pissiphany.home.data.service.data.ThemisApiV2TaskDataService
import com.pissiphany.home.domain.service.data.CalendarEntryDataService
import com.pissiphany.home.domain.service.data.TaskDataService
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by kierse on 2016-08-31.
 */
@Module
class DataServiceModule {
    @Provides
    fun provideThemisApiV2RetrofitService(@Named("url") url: String, @Named("token") token: String)
            : ThemisApiV2RetrofitService = buildService(url, token)

    @Provides
    fun provideMatterDataService(service: ThemisApiV2RetrofitService)
            : MatterDataService = ThemisApiV2MatterDataService(service)

    @Provides
    fun provideTaskDataService(service: ThemisApiV2RetrofitService)
            : TaskDataService = ThemisApiV2TaskDataService(service)

    @Provides
    fun provideCalendarEntryDataService(service: ThemisApiV2RetrofitService)
            : CalendarEntryDataService = ThemisApiV2CalendarEntryDataService(service)
}