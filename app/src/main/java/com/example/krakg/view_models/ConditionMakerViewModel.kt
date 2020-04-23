package com.example.krakg.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.krakg.models.ConditionModel

object ConditionMakerViewModel : ViewModel() {

    private val conditionList: MutableLiveData<MutableList<ConditionModel>> by lazy {
        MutableLiveData<MutableList<ConditionModel>>().also {
            it.value = mutableListOf<ConditionModel>(
                ConditionModel("Buy","if","daily","price","5%","greater than","weekly","price","$100.00"),
                ConditionModel("Sell","if","weekly","avg","1%","less than","weekly","price","$50.00"),
                ConditionModel("Buy","if","weekly","price","10%","greater than","weekly","avg","$3.00")
            )
        }
    }

    fun addConditions (conditionModel: ConditionModel){
        conditionList.value!!.add(conditionModel)
        conditionList.postValue(conditionList.value)
    }

    fun removeCondition(position:Int){
        conditionList.value!!.removeAt(position)
        conditionList.postValue(conditionList.value)
    }

    fun swap(position: Int){
        val tempCurrent = conditionList.value!![position]
        val tempNext = conditionList.value!![position+1]
        conditionList.value!![position] = tempNext.also { conditionList.value!![position+1] = tempCurrent}

        conditionList.postValue(conditionList.value)
    }


    fun getConditions(): MutableLiveData<MutableList<ConditionModel>> =
        conditionList

}