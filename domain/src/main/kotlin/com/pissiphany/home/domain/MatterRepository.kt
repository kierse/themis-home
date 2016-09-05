package com.pissiphany.home.domain

import com.pissiphany.home.domain.model.Matter
import rx.Observable
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by kierse on 2016-08-30.
 */
class MatterRepository @Inject constructor(@Named("api") val dataService: DataService) {
    fun matters(params: Map<String, String>) : Observable<List<Matter>> {
        return dataService.matters(params)
    }
}