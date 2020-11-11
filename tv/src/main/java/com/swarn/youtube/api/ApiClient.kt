package com.swarn.youtube.api

import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Swarn Singh.
 */
const val TIME_OUT = 10L

object ApiClient {
    private const val BASE_URL = "https://www.googleapis.com/youtube/v3/"

    private var adapterBuilder: retrofit2.Retrofit.Builder? = null

    private fun createDefaultAdapter() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .dispatcher(dispatcher)
            .retryOnConnectionFailure(true)
            .build()

        adapterBuilder = retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
    }

    fun <S> createService(serviceClass: Class<S>): S {
        if (adapterBuilder == null) {
            createDefaultAdapter()
        }
        return this.adapterBuilder!!.build().create(serviceClass)
    }
}