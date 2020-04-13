package com.example.krakg.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.models.ExpandedBotCardModel

object ExpandedBotViewModel : ViewModel() {

    private val expandedBotIndicatorList: MutableLiveData<MutableList<ExpandedBotCardModel>> by lazy {
        MutableLiveData<MutableList<ExpandedBotCardModel>>().also {
            it.value = mutableListOf<ExpandedBotCardModel>(
                ExpandedBotCardModel("Net Change", 2.3, null, "%", false, null),
                ExpandedBotCardModel("Gross", 800.2, "$",null, false, null),
                ExpandedBotCardModel("Value", 4000.5, "$",null, false, null),
                ExpandedBotCardModel("Avg", 82.1, null, "%", false, null),
                ExpandedBotCardModel("Trades/Hr", 40.7, null, null, false, null),
                ExpandedBotCardModel("Total Trades", 10.9, null, null, false, null),
                ExpandedBotCardModel("Time Up", 100.23, null, "sec", false, null),
                ExpandedBotCardModel("Paper Trading", "true", null, null, false, null),
                ExpandedBotCardModel("Conditions List", 5, null, null, false, null)
            )
        }
    }


    fun addIndicator (expandedBotCardModel: ExpandedBotCardModel){
        expandedBotIndicatorList.value!!.add(expandedBotCardModel)
        expandedBotIndicatorList.postValue(
            expandedBotIndicatorList.value)
    }

    fun removeIndicator(position:Int){
        expandedBotIndicatorList.value!!.removeAt(position)
        expandedBotIndicatorList.postValue(
            expandedBotIndicatorList.value)
    }

    fun updateIndicator(position: Int,indicator: ExpandedBotCardModel ){
        expandedBotIndicatorList.value!![position] = indicator
        expandedBotIndicatorList.postValue(
            expandedBotIndicatorList.value)
    }

    fun getInidcators(): MutableLiveData<MutableList<ExpandedBotCardModel>> =
        expandedBotIndicatorList




}