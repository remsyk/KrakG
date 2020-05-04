package com.example.krakg.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.log
import com.example.krakg.models.IndicatorGuideModel

object IndicatorGuideViewModel : ViewModel() {

    //TODO remove this live data list, it really is not needed for this
    private val indicatorList: MutableLiveData<MutableList<IndicatorGuideModel>> by lazy {
        MutableLiveData<MutableList<IndicatorGuideModel>>().also {
            it.value = mutableListOf<IndicatorGuideModel>(
                IndicatorGuideModel("Buy", "This is what it take to win at life"),
                IndicatorGuideModel("Boy", "This is what it take to win at life"),
                IndicatorGuideModel("Bay", "This is what it take to win at life"),
                IndicatorGuideModel("Bar", "This is what it take to win at life"),
                IndicatorGuideModel("Ban", "This is what it take to win at life"),
                IndicatorGuideModel("Avg", "This is what it take to win at life"),
                IndicatorGuideModel("Greed", "This is what it take to win at life"),
                IndicatorGuideModel("Funny", "This is what it take to win at life")
            )
        }
    }

    /*private val tempList:MutableLiveData<MutableList<IndicatorGuideModel>> by lazy {
        MutableLiveData<MutableList<IndicatorGuideModel>>().also {
            it.value = getIndicators().value
        }
    }*/


    /*fun filter(query: String) {
        tempList.postValue((indicatorList.value!!.filter {
            it.title.startsWith(query, true)
        } as MutableList<IndicatorGuideModel>))
    }*/

    fun filter(query: String):MutableList<IndicatorGuideModel> = indicatorList.value!!.filter {
        it.title.startsWith(query, true)
    } as MutableList<IndicatorGuideModel>




    fun getIndicators(): MutableLiveData<MutableList<IndicatorGuideModel>> = indicatorList

}