package com.pissiphany.home.data

import com.pissiphany.home.domain.DataService
import com.pissiphany.home.domain.model.Matter
import rx.Observable

/**
 * Created by kierse on 2016-08-30.
 */
class ThemisApiV2Service(val service: ThemisApiV2RetrofitService) : DataService {
    override fun matters(params: Map<String, String>): Observable<List<Matter>> {
        return service.matters(params).flatMap { response -> Observable.just(response.list()) }
    }
}