package com.example.krakg.ui.fragments.bots

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.DataManager
import com.example.krakg.models.BotModel

object BotsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text

    private val botList = MutableLiveData<MutableList<BotModel>>().apply {
        value = mutableListOf<BotModel>(
            BotModel("Bot 1",1.3,"BTC>LTC","$370.90","+4.3%"),
            BotModel("Bot 2",1.3,"BTC>LTC","$428.60","-8.3%"),
            BotModel("Bot 3",1.3,"BTC>LTC","$51.54","+1.3%"))
    }

    fun addBot (botModel: BotModel){
        botList.value!!.add(botModel)
    }

    fun getBots(): MutableLiveData<MutableList<BotModel>>  = botList

}