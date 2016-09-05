package com.pissiphany.home.domain

import com.pissiphany.home.domain.model.Matter
import rx.Observable

/**
 * Created by kierse on 2016-08-27.
 */
interface DataService {
    fun matters(params: Map<String, String>) : Observable<List<Matter>>
}