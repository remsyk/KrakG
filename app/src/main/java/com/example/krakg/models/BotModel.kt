package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class  BotModel(
    @SerializedName("title")
    var title: String,
    @SerializedName("exchange")
    var exchange: String?,
    @SerializedName("value")
    var value: String?,
    @SerializedName("gross")
    var gross: String,
    @SerializedName("net_change")
    var netChange: String,
    @SerializedName("avg")
    var avg: String,
    @SerializedName("total_trades")
    var totalTrades: String,
    @SerializedName("paper_trading")
    var paperTrading: Boolean,
    @SerializedName("condition_list")
    var conditionList: String
)