package com.example.krakg


import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory.*
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitFactory {

    private const val TAG: String = "RetrofitFactory"
    private var gson = GsonBuilder()
        .setLenient()
        .create()!!

    //build retrofit to make request
    fun create(): RetrofitInterface {
        Log.i(TAG, "create: ")
        val retrofit = Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(getOkHttpClient())
            .baseUrl("https://api.kraken.com")
            .build()
        return retrofit.create(RetrofitInterface::class.java)
    }

    //leverage OKHttpClient to reuse threads and reduce latency
    private fun getOkHttpClient(): OkHttpClient {

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(httpLoggingInterceptor)
            //needed to set timemout for the usalinkysystem server, or you will get an error
            this.readTimeout(30, TimeUnit.SECONDS)
            this.connectTimeout(30, TimeUnit.SECONDS)
        }.build()
        return okHttpClient
    }
}
