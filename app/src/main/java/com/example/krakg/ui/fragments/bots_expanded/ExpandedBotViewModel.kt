package com.example.krakg.ui.fragments.bots_expanded

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.DataManager
import com.example.krakg.log
import com.example.krakg.models.BotModel
import com.example.krakg.models.ConditionModel
import com.example.krakg.models.ExpandedBotCardModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.internal.notify

object ExpandedBotViewModel : ViewModel() {

    private val expandedBotIndicatorList: MutableLiveData<MutableList<ExpandedBotCardModel>> by lazy {
        MutableLiveData<MutableList<ExpandedBotCardModel>>().also {
            it.value = mutableListOf<ExpandedBotCardModel>(
                ExpandedBotCardModel("Net Change", 2.3, null, "%", false, null),
                ExpandedBotCardModel("Gross", 800.2, "$",null, true, null),
                ExpandedBotCardModel("Value", 4000.5, "$",null, false, null),
                ExpandedBotCardModel("Avg", 82.1, null, "%", true, null),
                ExpandedBotCardModel("Trades/Hr", 40.7, null, null, false, null),
                ExpandedBotCardModel("Total Trades", 10.9, null, null, true, null),
                ExpandedBotCardModel("Time Up", 100.23, null, "sec", false, null),
                ExpandedBotCardModel("Paper Trading", "True", null, null, false, null),
                ExpandedBotCardModel("Conditions List", 5, null, null, true, null)

            )
        }
    }


    fun addIndicator (expandedBotCardModel: ExpandedBotCardModel){
        expandedBotIndicatorList.value!!.add(expandedBotCardModel)
        expandedBotIndicatorList.postValue(expandedBotIndicatorList.value)
    }

    fun removeIndicator(position:Int){
        expandedBotIndicatorList.value!!.removeAt(position)
        expandedBotIndicatorList.postValue(expandedBotIndicatorList.value)
    }

    fun updateIndicator(position: Int,indicator: ExpandedBotCardModel ){
        expandedBotIndicatorList.value!![position] = indicator
        expandedBotIndicatorList.postValue(expandedBotIndicatorList.value)
    }

    fun getInidcators(): MutableLiveData<MutableList<ExpandedBotCardModel>> = expandedBotIndicatorList

}