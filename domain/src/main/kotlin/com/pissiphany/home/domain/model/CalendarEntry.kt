package com.pissiphany.home.domain.model

import org.joda.time.DateTime

/**
 * Created by kierse on 2016-08-27.
 */
data class CalendarEntry(
        val id: Long?,
        val createdAt: DateTime?,
        val updatedAt: DateTime?,

        val summary: String?,
        val startDate: DateTime?
)
