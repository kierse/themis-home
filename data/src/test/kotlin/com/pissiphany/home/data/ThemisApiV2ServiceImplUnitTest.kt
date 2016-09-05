package com.pissiphany.home.data

import com.pissiphany.home.domain.model.Matter
import org.junit.Before
import org.junit.Test
import rx.Observable
import rx.observers.TestSubscriber

/**
 * Created by kierse on 2016-08-30.
 */
class ThemisApiV2ServiceImplUnitTest {
    lateinit var service: ThemisApiV2Service

    @Before
    fun setup() {
        val (root, token) = getApiResources()
        service = ThemisApiV2Service(
                buildService(root, token)
        )
    }

    @Test
    fun matters() {
        val subscriber = TestSubscriber<Matter>()
        val limit = 3

        service.matters(mapOf(Pair(ThemisApiV2RetrofitService.Params.LIMIT, limit.toString())))
                .flatMap { list -> Observable.from(list) }
                .subscribe(subscriber)

        subscriber.assertCompleted()
        subscriber.assertNoErrors()
        subscriber.assertValueCount(limit)
    }
}