package com.pissiphany.home.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.pissiphany.home.data.gson.DateTimeTypeAdapter
import com.pissiphany.home.data.response.CalendarEntryListResponse
import com.pissiphany.home.data.response.MatterListResponse
import com.pissiphany.home.data.response.TaskListResponse
import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap
import rx.Observable

/**
 * Created by kierse on 2016-08-31.
 */
interface ThemisApiV2RetrofitService {
    class Params private constructor() {
        companion object {
            val LIMIT = "limit"
            val LIMIT_DEFAULT = 200
        }
    }

    abstract class ListResponse<out T>(
            val records: Int,
            val limit: Int,
            val nextOffset: Long,
            val orderDir: String,
            val publishedAt: DateTime
    ) {
        abstract fun list() : List<T>
    }

    @GET("api/v2/matters")
    fun matters(@QueryMap() params: Map<String, String>) : Observable<MatterListResponse>

    @GET("api/v2/tasks")
    fun tasks(@QueryMap params: Map<String, String>) : Observable<TaskListResponse>

    @GET("api/v2/calendar_entries")
    fun calendarEntries(@QueryMap params: Map<String, String>) : Observable<CalendarEntryListResponse>
}

fun buildService(url: String, token: String) : ThemisApiV2RetrofitService {
    return Retrofit.Builder()
            .baseUrl(url)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            .client(buildHttpClient(token))
            .build()
            .create(ThemisApiV2RetrofitService::class.java)
}

private fun buildGson() : Gson {
    return GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd'T'HH:mm'Z'")
            .registerTypeAdapter(DateTime::class.java, DateTimeTypeAdapter())
            .create()
}

private fun buildHttpClient(token: String) : OkHttpClient {
    return OkHttpClient.Builder()
            .addInterceptor(buildInterceptor(token))
            .build()
}

private fun buildInterceptor(token: String) : Interceptor {
    return Interceptor { chain: Interceptor.Chain ->
        val request = chain.request()
        return@Interceptor chain.proceed(
                request.newBuilder()
                        .headers(addDefaultHeaders(request.headers(), token))
                        .url(addDefaultQueryParams(request.url()))
                        .build()
        )
    }
}

private fun addDefaultHeaders(headers: Headers, token: String) : Headers {
    return headers.newBuilder()
            .add("Authorization", "Bearer $token")
            .build()
}

private fun addDefaultQueryParams(url: HttpUrl) : HttpUrl {
    if (url.queryParameter(ThemisApiV2RetrofitService.Params.LIMIT) != null) return url

    return url.newBuilder()
            .addQueryParameter(
                    ThemisApiV2RetrofitService.Params.LIMIT,
                    ThemisApiV2RetrofitService.Params.LIMIT_DEFAULT.toString()
            )
            .build()
}
