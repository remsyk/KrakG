package com.example.krakg.view_models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.log
import com.example.krakg.retrofit.RetrofitFactory
import com.example.krakg.services.TestService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import java.util.*

object DashboardViewModel : ViewModel() {

    val retrofitInterface by lazy {
        RetrofitFactory.create()
    }

    @SuppressLint("CheckResult")
    fun getServerTime(): MutableLiveData<String> {
        val serverTime: MutableLiveData<String> = MutableLiveData("No Time Yet!")
        retrofitInterface.getServerTime()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> serverTime.value = response },
                { error -> Log.e("DashboardViewModel", "API request error", error) }
            )
        return serverTime
    }

    @SuppressLint("CheckResult")
    fun getTicker(pair:String): MutableLiveData<Array<String>> {
        lateinit var serverTime: MutableLiveData<Array<String>>
        retrofitInterface.getTicker()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> serverTime.value = response },
                { error -> Log.e("DashboardViewModel", "API request error", error) }
            )
        return serverTime
    }

    fun getBotName(callBack: (String) -> Unit) {
        val randomUUI = java.util.UUID.randomUUID().toString()
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofitInterface.getBotName("https://wunameaas.herokuapp.com/wuami/:$randomUUI").await()
            withContext(Dispatchers.Main) {
                callBack(response)
            };
        }
    }


}


