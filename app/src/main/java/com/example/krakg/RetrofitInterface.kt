package com.example.krakg

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("/")
    fun getTestAsync(): Deferred<Response<String>>

}