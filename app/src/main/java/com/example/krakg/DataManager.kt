package com.example.krakg

import android.annotation.SuppressLint
import android.util.Log
import com.example.krakg.models.BotModel
import com.example.krakg.retrofit.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DataManager {

    private val botList = mutableListOf<BotModel>(
        BotModel("Bot 1",1.3,"BTC>LTC","$370.90","+4.3%"),
        BotModel("Bot 2",1.3,"BTC>LTC","$428.60","-8.3%"),
        BotModel("Bot 3",1.3,"BTC>LTC","$51.54","+1.3%")
    )

    val retrofitInterface by lazy {
        RetrofitFactory.create()
    }

    fun getBotsList() = botList


    fun addBots(bot: BotModel){
        botList.add(bot)
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