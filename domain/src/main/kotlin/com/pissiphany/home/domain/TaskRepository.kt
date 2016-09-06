package com.pissiphany.home.domain

import com.pissiphany.home.domain.model.Task
import com.pissiphany.home.domain.service.data.TaskDataService
import rx.Observable
import javax.inject.Inject

/**
 * Created by kierse on 2016-09-05.
 */
class TaskRepository @Inject constructor(val dataService: TaskDataService) {
    fun tasks(params: Map<String, String>) : Observable<List<Task>> {
        return dataService.tasks(params)
    }
}