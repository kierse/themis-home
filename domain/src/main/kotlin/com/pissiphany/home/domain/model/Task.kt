package com.pissiphany.home.domain.model

import org.joda.time.DateTime

/**
 * Created by kierse on 2016-08-27.
 */
data class Task(
        val id: Long?,
        val createdAt: DateTime?,
        val updatedAt: DateTime?,

        val name: String?,
        val dueAt: DateTime?,
        val priority: String?
)
