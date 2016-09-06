package com.pissiphany.home.data.service.data

import com.pissiphany.home.data.ThemisApiV2RetrofitService
import com.pissiphany.home.domain.service.data.MatterDataService
import com.pissiphany.home.domain.model.Matter
import rx.Observable

/**
 * Created by kierse on 2016-08-30.
 */
class ThemisApiV2MatterDataService(val service: ThemisApiV2RetrofitService) : MatterDataService {
    override fun matters(params: Map<String, String>): Observable<List<Matter>> {
        return service.matters(params).flatMap { response -> Observable.just(response.list()) }
    }
}