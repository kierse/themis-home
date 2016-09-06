package com.pissiphany.home.domain

import com.pissiphany.home.domain.model.CalendarEntry
import com.pissiphany.home.domain.service.data.CalendarEntryDataService
import rx.Observable
import javax.inject.Inject

/**
 * Created by kierse on 2016-09-05.
 */
class CalendarEntryRepository @Inject constructor(val dataService: CalendarEntryDataService) {
    fun calendarEntries(params: Map<String, String>) : Observable<List<CalendarEntry>> {
        return dataService.calendarEntries(params)
    }
}