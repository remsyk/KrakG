package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class BotModel(
    @SerializedName("title")
    var title: String,
    @SerializedName("graph")
    var graph: Double,
    @SerializedName("exchange")
    var exchange: String?,
    @SerializedName("value")
    var value: String?,
    @SerializedName("gross")
    var gross: String,
    @SerializedName("expandedBot")
    var expandedBot: ExpandedBotCardModel
)