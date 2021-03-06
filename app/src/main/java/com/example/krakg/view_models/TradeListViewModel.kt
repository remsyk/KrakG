package com.example.krakg.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.models.ConditionModel
import com.example.krakg.models.TradeItemModel

object TradeListViewModel : ViewModel() {

//TODO sync the trades with those in the database

    private val tradeList: MutableLiveData<MutableList<TradeItemModel>> by lazy {
        MutableLiveData<MutableList<TradeItemModel>>().also {
            it.value = mutableListOf<TradeItemModel>(
                TradeItemModel("Funny", "BTC/USD", "3.324BTC", "3-2-20;18:00", false),
                TradeItemModel("House", "USD/BTC", "5.2BTC", "3-2-20;15:00", false),
                TradeItemModel("Cards", "BTC/USD", "8.34BTC", "3-2-20;10:00", true),
                TradeItemModel("Cats", "USD/BTC", "1.3BTC", "3-2-20;2:00", true)
            )
        }
    }


    fun addTrades(tradeModel: TradeItemModel) {
        tradeList.value!!.add(tradeModel)
        tradeList.postValue(
            tradeList.value
        )
    }

    fun removeTrade(position: Int) {
        tradeList.value!!.removeAt(position)
        tradeList.postValue(
            tradeList.value
        )
    }


    private val tempList: MutableLiveData<MutableList<TradeItemModel>> by lazy {
        MutableLiveData<MutableList<TradeItemModel>>().also {
            it.value = getTrades().value
        }
    }


    fun filter(query: String){
      tempList.postValue(  tradeList.value!!.filter {
          it.botName.startsWith(query, true)
      } as MutableList<TradeItemModel>  )
    }


    fun getFilteredList(): MutableLiveData<MutableList<TradeItemModel>> = tempList
    fun getTrades(): MutableLiveData<MutableList<TradeItemModel>> = tradeList

}