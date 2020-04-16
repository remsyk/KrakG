package com.example.krakg.view_models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.log
import com.example.krakg.retrofit.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object DashboardViewModel : ViewModel() {

    private val pairTickerData: MutableLiveData<Array<String>> by lazy {
        MutableLiveData<Array<String>>().also {
            it.value = arrayOf("werw","werwe")
        }
    }

    val retrofitInterface by lazy {
        RetrofitFactory.create()
    }


    @SuppressLint("CheckResult")
    fun getApiServerTime(): MutableLiveData<String> {
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
    fun getApiTicker(pair:String): MutableLiveData<Array<String>> {
        lateinit var ticker: MutableLiveData<Array<String>>
        retrofitInterface.getTicker(listOf("BTC","USD"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> ticker.value = response },
                { error -> Log.e("DashboardViewModel", "API request error", error) }
            )
        return ticker
    }

    @SuppressLint("CheckResult")
    fun getApiTicker2(pair:String) {
        retrofitInterface.getTicker(listOf("BTC","USD"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->  response.log() },
                { error -> Log.e("DashboardViewModel", "API request error", error) }
            )
    }

    fun getTicker():MutableLiveData<Array<String>>{
        return pairTickerData
    }


    fun getApiBotName(callBack: (String) -> Unit) {
        val randomUUI = java.util.UUID.randomUUID().toString()
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofitInterface.getBotName("https://wunameaas.herokuapp.com/wuami/:$randomUUI").await()
            withContext(Dispatchers.Main) {
                callBack(response)
            };
        }
    }


}


