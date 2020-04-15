package com.example.krakg.retrofit

import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url


interface RetrofitInterface {

    //@Headers("API-Key: Bar", "API-Sign: Pong")
    @GET("/0/public/Time")
    fun getServerTime(): Observable<String>


    @Headers("Accept:text/plain")
    @GET
    fun getBotName(@Url url: String ): Deferred<String>


    @GET("/0/public/Ticker")
    fun getTicker():Observable<Array<String>>
}