package com.example.krakg.view_models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.log
import com.example.krakg.retrofit.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.awaitResponse

object DashboardViewModel : ViewModel() {

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

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    //val text: LiveData<String> = _text

    fun getBotName():String = retrofitInterface.getBotName("https://wunameaas.herokuapp.com/wuami/:from").toString()
}


