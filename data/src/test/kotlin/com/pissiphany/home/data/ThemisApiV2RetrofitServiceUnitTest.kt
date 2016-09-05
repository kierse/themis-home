package com.pissiphany.home.data

import com.pissiphany.home.data.response.MatterListResponse
import org.junit.Before
import org.junit.Test
import rx.observers.TestSubscriber

/**
 * Created by kierse on 2016-08-29.
 */
class ThemisApiV2RetrofitServiceUnitTest {
    lateinit var service: ThemisApiV2RetrofitService

    @Before
    fun setup() {
        val (root, token) = getApiResources()
        service = buildService(root, token)
    }

    @Test
    fun matterListResponse() {
        val subscriber = TestSubscriber<MatterListResponse>()

        service.matters(mapOf()).subscribe(subscriber)

        subscriber.assertCompleted()
        subscriber.assertValueCount(1)
    }
}