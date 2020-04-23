package com.example.krakg.retrofit

import com.example.krakg.models.GetTickerModel
import com.example.krakg.models.PutOrderModel
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

    @GET("/0/public/Spread")
    fun getSpread(@Query("pair") pair:String,@Query("spread") spread:String ):Observable<String>

    @GET("/0/public/Depth")
    fun getPublicOrderBook(@Query("pair") pair:String ):Observable<String>

    @PUT("/0/private/AddOrder")
    fun putOrder(@QueryMap orderModel:PutOrderModel ):Deferred<String>

    @PUT("/0/private/CancelOrder")
    fun cancelOrder(@Query("txid") txid:String ):Deferred<String>

}