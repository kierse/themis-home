package com.pissiphany.home.data.service.data

import com.pissiphany.home.data.ThemisApiV2RetrofitService
import com.pissiphany.home.domain.model.Task
import com.pissiphany.home.domain.service.data.TaskDataService
import rx.Observable

/**
 * Created by kierse on 2016-09-05.
 */
class ThemisApiV2TaskDataService(val service: ThemisApiV2RetrofitService) : TaskDataService {
    override fun tasks(params: Map<String, String>): Observable<List<Task>> {
        return service.tasks(params).flatMap { response -> Observable.just(response.list()) }
    }
}