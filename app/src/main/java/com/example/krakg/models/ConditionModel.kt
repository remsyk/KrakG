package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class ConditionModel(
    @SerializedName("buySell")
    var buySell: String,
    @SerializedName("_if")
    var _if: String,
    @SerializedName("interval1")
    var interval1: String?,
    @SerializedName("indicator1")
    var indicator1: String?,
    @SerializedName("change")
    var change: String,
    @SerializedName("operator")
    var operator: String,
    @SerializedName("interval2")
    var interval2: String,
    @SerializedName("indicator2")
    var indicator2: String,
    @SerializedName("amount")
    var amount: String
)