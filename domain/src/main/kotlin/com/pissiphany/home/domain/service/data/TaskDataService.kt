package com.pissiphany.home.domain.service.data

import com.pissiphany.home.domain.model.Task
import rx.Observable

/**
 * Created by kierse on 2016-09-05.
 */
interface TaskDataService {
    fun tasks(params: Map<String, String>) : Observable<List<Task>>
}