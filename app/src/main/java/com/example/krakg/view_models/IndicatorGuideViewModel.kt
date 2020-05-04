package com.example.krakg.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.models.IndicatorGuideModel

object IndicatorGuideViewModel : ViewModel() {


    private val indicatorList: MutableLiveData<MutableList<IndicatorGuideModel>> by lazy {
        MutableLiveData<MutableList<IndicatorGuideModel>>().also {
            it.value = mutableListOf<IndicatorGuideModel>(
                IndicatorGuideModel("Buy", "This is what it take to win at life"),
                IndicatorGuideModel("Avg", "This is what it take to win at life"),
                IndicatorGuideModel("Greed", "This is what it take to win at life"),
                IndicatorGuideModel("Funny", "This is what it take to win at life")
            )
        }
    }

    fun addTrades (itemModel: IndicatorGuideModel){
        indicatorList.value!!.add(itemModel)
        indicatorList.postValue(indicatorList.value)
    }

    fun removeTrade(position:Int){
        indicatorList.value!!.removeAt(position)
        indicatorList.postValue(indicatorList.value)
    }

    fun filter(userInput: String){

        indicatorList.value!!.filter {
            it.title.contains(userInput)
        }
    }




    fun getTrades(): MutableLiveData<MutableList<IndicatorGuideModel>> = indicatorList

}