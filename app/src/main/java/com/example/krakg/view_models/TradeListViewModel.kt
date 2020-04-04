package com.example.krakg.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.models.ConditionModel
import com.example.krakg.models.TradeItemModel

object TradeListViewModel : ViewModel() {


    private val tradeList: MutableLiveData<MutableList<TradeItemModel>> by lazy {
        MutableLiveData<MutableList<TradeItemModel>>().also {
            it.value = mutableListOf<TradeItemModel>(
                TradeItemModel("BTC>LTC", "3.324BTC", "3-2-20;18:00",false),
                TradeItemModel("LTC>BTC", "5.2BTC", "3-2-20;15:00",false),
                TradeItemModel("BTC>LTC", "8.34BTC", "3-2-20;10:00",true),
                TradeItemModel("LTC>BTC", "1.3BTC", "3-2-20;2:00",true)
            )
        }
    }

    fun addTrades (tradeModel: TradeItemModel){
        tradeList.value!!.add(tradeModel)
        tradeList.postValue(
            tradeList.value)
    }

    fun removeTrade(position:Int){
        tradeList.value!!.removeAt(position)
        tradeList.postValue(
            tradeList.value)
    }


    fun getTrades(): MutableLiveData<MutableList<TradeItemModel>> = tradeList

}