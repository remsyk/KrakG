package com.example.krakg.retrofit

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers


interface RetrofitInterface {

    //@Headers("API-Key: Bar", "API-Sign: Pong")
    @GET("/0/public/Time")
    fun getServerTime(): Observable<String>
}