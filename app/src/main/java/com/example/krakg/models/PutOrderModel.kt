package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class PutOrderModel (
    @SerializedName("pair")
    var pair: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("orderType")
    var orderType: String,
    @SerializedName("price")
    var price: String?,
    @SerializedName("price2")
    var price2: String?,
    @SerializedName("volume")
    var volume: String,
    @SerializedName("leverage")
    var leverage: String?,
    @SerializedName("oflags")
    var oflags: String?,
    @SerializedName("starttm")
    var starttm: String?,
    @SerializedName("epiretm")
    var epiretm: String?,
    @SerializedName("userref")
    var userref: String?,
    @SerializedName("validate")
    var validate: String?
)
