package com.pissiphany.home.domain.model

import org.joda.time.DateTime

/**
 * Created by kierse on 2016-08-27.
 */
data class Matter(
        val id: Long?,
        val createdAt: DateTime?,
        val updatedAt: DateTime?,

        val description: String?,
        val displayNumber: String?,
        val status: String?,
        val clientReference: String?,
        val location: String?,

        val pendingDate: DateTime?,
        val openDate: DateTime?,
        val closeDate: DateTime?
)