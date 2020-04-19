package com.example.krakg.view_models

import android.annotation.SuppressLint
import android.text.GetChars
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.log
import com.example.krakg.models.GetTickerModel
import com.example.krakg.retrofit.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object DashboardViewModel : ViewModel() {

    private val pairTickerData: MutableLiveData<MutableList<GetTickerModel>> by lazy {
        MutableLiveData<MutableList<GetTickerModel>>().also {
            it.value = mutableListOf(
                GetTickerModel(null,null,null,null,null,null,null,null,null),
                GetTickerModel(null,null,null,null,null,null,null,null,null),
                GetTickerModel(null,null,null,null,null,null,null,null,null)
            )
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
    fun getApiTicker(pair:String) {
        retrofitInterface.getTicker(pair)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response -> pairTickerData.value!![1] = response },
                { error -> Log.e("DashboardViewModel", "API request error", error) }
            )

        pairTickerData.postValue (pairTickerData.value)
    }

    fun getTicker():MutableLiveData<MutableList<GetTickerModel>> = pairTickerData


}


