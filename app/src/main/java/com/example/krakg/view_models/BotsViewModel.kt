package com.example.krakg.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.models.BotModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object BotsViewModel : ViewModel() {


    private val botList: MutableLiveData<MutableList<BotModel>> by lazy {
        MutableLiveData<MutableList<BotModel>>().also {
            it.value = mutableListOf<BotModel>(
                BotModel("Intellectual Dominator",1.3,"BTC/LTC","$370.90","+4.3%",null),
                BotModel("B Money",1.3,"BTC/LTC","$428.60","-8.3%",null),
                BotModel("Respected Knight",1.3,"BTC/LTC","$51.54","+1.3%",null))
        }
    }

    fun addBot (botModel: BotModel){
        botList.value!!.add(botModel)
        botList.postValue(botList.value)
    }

    fun removeBot(position:Int){
        botList.value!!.removeAt(position)
        botList.postValue(botList.value)
    }


    fun getBots(): MutableLiveData<MutableList<BotModel>> = botList



    fun getApiBotName(callBack: (String) -> Unit) {
        val randomUUI = java.util.UUID.randomUUID().toString()
        CoroutineScope(Dispatchers.IO).launch {
            val response = DashboardViewModel.retrofitInterface.getBotName("https://wunameaas.herokuapp.com/wuami/:$randomUUI").await()
            withContext(Dispatchers.Main) {
                callBack(response)
            };
        }
    }
}