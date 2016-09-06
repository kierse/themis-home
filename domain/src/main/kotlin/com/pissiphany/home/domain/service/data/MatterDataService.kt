package com.pissiphany.home.domain.service.data

import com.pissiphany.home.domain.model.Matter
import rx.Observable

/**
 * Created by kierse on 2016-08-27.
 */
interface MatterDataService {
    fun matters(params: Map<String, String>) : Observable<List<Matter>>
}