package com.example.krakg.retrofit

import com.example.krakg.models.GetTickerModel
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.*


interface RetrofitInterface {

    //@Headers("API-Key: Bar", "API-Sign: Pong")
    @GET("/0/public/Time")
    fun getServerTime(): Observable<String>


    @Headers("Accept:text/plain")
    @GET
    fun getBotName(@Url url: String ): Deferred<String>


    @GET("/0/public/Ticker")
    fun getTicker(@Query("pair") pair:String):Observable<GetTickerModel>
}