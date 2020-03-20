package com.example.krakg.ui.fragments.bots

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.log
import com.example.krakg.models.BotModel

object BotsViewModel : ViewModel() {


    private val botList: MutableLiveData<MutableList<BotModel>> by lazy {
        MutableLiveData<MutableList<BotModel>>().also {
            it.value = mutableListOf<BotModel>(
                BotModel("Bot 1",1.3,"BTC>LTC","$370.90","+4.3%"),
                BotModel("Bot 2",1.3,"BTC>LTC","$428.60","-8.3%"),
                BotModel("Bot 3",1.3,"BTC>LTC","$51.54","+1.3%"))
        }
    }

    fun addBot (botModel: BotModel){
        botList.value!!.add(botModel)
        botList.postValue(botList.value)
    }


    fun getBots(): MutableLiveData<MutableList<BotModel>> = botList

}