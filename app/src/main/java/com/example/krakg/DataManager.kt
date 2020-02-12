package com.example.krakg

import android.annotation.SuppressLint
import android.util.Log
import com.example.krakg.retrofit.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DataManager {

    val retrofitInterface by lazy {
        RetrofitFactory.create()
    }

    @SuppressLint("CheckResult")
    fun getServerTime() {
        "we got here".log()
        retrofitInterface.getServerTime()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> response.log() },
                { error -> Log.e("ApiHandler", "API request error", error) }
            )
    }

}