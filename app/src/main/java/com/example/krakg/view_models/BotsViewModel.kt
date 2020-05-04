package com.example.krakg.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.models.BotModel
import com.example.krakg.realm.DBManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object BotsViewModel : ViewModel() {

    val dbManager = DBManager()

    private val botList: MutableLiveData<MutableList<BotModel>> by lazy {
        MutableLiveData<MutableList<BotModel>>().also {
            it.value =  dbManager.getBots()
        }
    }

    fun addBot (botModel: BotModel){
        botList.value!!.add(botModel)
        botList.postValue(botList.value)
        dbManager.addBot(botModel, botList.value!!.size+1)
    }

    fun removeBot(position:Int){
        dbManager.delBot(botList.value!![position].title.substring(0,4))
        botList.value!!.removeAt(position)
        botList.postValue(botList.value)
    }

    fun updatePaperTrading(position: Int,bool: Boolean){
        botList.value!![position].paperTrading = bool
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