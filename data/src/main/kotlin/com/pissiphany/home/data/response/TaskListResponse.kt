package com.pissiphany.home.data.response

import com.pissiphany.home.data.ThemisApiV2RetrofitService
import com.pissiphany.home.domain.model.Task
import org.joda.time.DateTime

/**
 * Created by kierse on 2016-09-05.
 */
class TaskListResponse : ThemisApiV2RetrofitService.ListResponse<Task> {
    private val tasks: List<Task>

    constructor(records: Int, limit: Int, nextOffset: Long, orderDir: String, publishedAt: DateTime, tasks: List<Task>)
    : super(records, limit, nextOffset, orderDir, publishedAt) {
        this.tasks = tasks
    }

    override fun list(): List<Task> = tasks
}