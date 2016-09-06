package com.pissiphany.home.domain.service.data

import com.pissiphany.home.domain.model.CalendarEntry
import rx.Observable

/**
 * Created by kierse on 2016-09-05.
 */
interface CalendarEntryDataService {
    fun calendarEntries(params: Map<String, String>) : Observable<List<CalendarEntry>>
}