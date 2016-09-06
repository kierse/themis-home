package com.pissiphany.home.data.response

import com.pissiphany.home.data.ThemisApiV2RetrofitService
import com.pissiphany.home.domain.model.CalendarEntry
import org.joda.time.DateTime

/**
 * Created by kierse on 2016-09-05.
 */
class CalendarEntryListResponse : ThemisApiV2RetrofitService.ListResponse<CalendarEntry> {
    private val calendar_entries: List<CalendarEntry>

    constructor(records: Int, limit: Int, nextOffset: Long, orderDir: String, publishedAt: DateTime, entries: List<CalendarEntry>)
    : super(records, limit, nextOffset, orderDir, publishedAt) {
        this.calendar_entries = entries
    }

    override fun list(): List<CalendarEntry> = calendar_entries
}