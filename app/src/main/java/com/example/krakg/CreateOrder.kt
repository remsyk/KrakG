package com.example.krakg

import com.example.krakg.models.ConditionModel
import com.example.krakg.models.PutOrderModel

class CreateOrder {


    fun getFullIndicator(interval: String,indicator:String):Double{
        //interval + indicator
        TODO()
        return 12.12
    }



    fun orderBTCUSD(condition:ConditionModel):PutOrderModel{


        when(condition.operator){

            ">"->{
                if(getFullIndicator(condition.indicator1!!,condition.interval1!!) > getFullIndicator(condition.indicator1!!,condition.interval1!!)){
                    TODO()
                }
            }
            "<"->{
                if(getFullIndicator(condition.indicator1!!,condition.interval1!!) < getFullIndicator(condition.indicator1!!,condition.interval1!!)){
                    TODO()
                }

            }
            "="->{
                if(getFullIndicator(condition.indicator1!!,condition.interval1!!) == getFullIndicator(condition.indicator1!!,condition.interval1!!)){
                    TODO()
                }
            }
        }

        return PutOrderModel("BTCUSD",condition.buySell,"market",null,null,condition.amount,null,null,null,null,null,null)
    }


}