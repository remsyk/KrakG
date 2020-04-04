package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class TradeItemModel(
    @SerializedName("pair")
    var pair: String,
    @SerializedName("amount")
    var amount: String,
    @SerializedName("time")
    var time: String,
    @SerializedName("executed")
    var executed: Boolean

)


