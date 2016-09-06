package com.pissiphany.home.domain

import com.pissiphany.home.domain.model.Matter
import com.pissiphany.home.domain.service.data.MatterDataService
import rx.Observable
import javax.inject.Inject

/**
 * Created by kierse on 2016-08-30.
 */
class MatterRepository @Inject constructor(val dataService: MatterDataService) {
    fun matters(params: Map<String, String>) : Observable<List<Matter>> {
        return dataService.matters(params)
    }
}