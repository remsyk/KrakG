package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class GetTickerModel(
    @SerializedName("a")
    val ask: Array<String>?,
    @SerializedName("b")
    val bid: Array<String>?,
    @SerializedName("c")
    val last: Array<String>?,
    @SerializedName("v")
    val volume: Array<String>?,
    @SerializedName("p")
    val volumeWeighted: Array<String>?,
    @SerializedName("t")
    val numTrades: Array<String>?,
    @SerializedName("l")
    val low: Array<String>?,
    @SerializedName("h")
    val high: Array<String>?,
    @SerializedName("o")
    val opening: String?
)