package com.example.krakg.ui.fragments.bots_expanded

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.DataManager
import com.example.krakg.log
import com.example.krakg.models.BotModel
import com.example.krakg.models.ConditionModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.internal.notify

object ConditionMakerViewModel : ViewModel() {


    private val conditionList: MutableLiveData<MutableList<ConditionModel>> by lazy {
        MutableLiveData<MutableList<ConditionModel>>().also {
            it.value = mutableListOf<ConditionModel>(
                ConditionModel("Buy","if","daily","price","5%","greater than","weekly","price"),
                ConditionModel("Sell","if","weekly","avg","1%","less than","weekly","price"),
                ConditionModel("Buy","if","weekly","price","10%","greater than","weekly","avg")
            )
        }
    }

    fun addConditions (conditionModel: ConditionModel){
        conditionList.value!!.add(conditionModel)
        conditionList.postValue(conditionList.value)
        getConditions().value!!.size.log()
    }


    fun getConditions(): MutableLiveData<MutableList<ConditionModel>> = conditionList

}