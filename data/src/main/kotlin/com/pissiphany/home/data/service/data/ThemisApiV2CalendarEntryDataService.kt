package com.pissiphany.home.data.service.data

import com.pissiphany.home.data.ThemisApiV2RetrofitService
import com.pissiphany.home.domain.model.CalendarEntry
import com.pissiphany.home.domain.service.data.CalendarEntryDataService
import rx.Observable

/**
 * Created by kierse on 2016-09-05.
 */
class ThemisApiV2CalendarEntryDataService(val service: ThemisApiV2RetrofitService) : CalendarEntryDataService {
    override fun calendarEntries(params: Map<String, String>): Observable<List<CalendarEntry>> {
        return service.calendarEntries(params).flatMap { response ->
            Observable.just(response.list())
        }
    }
}