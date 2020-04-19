package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class GetTickerModel(
    @SerializedName("error")
    val error: List<Any>,
    @SerializedName("result")
    val result: Result
) {
    data class Result(
        @SerializedName("XXBTZUSD")
        val BTCUSD: Pair,
        @SerializedName("XLTCZUSD")
        val LTCUSD: Pair,
        @SerializedName("XLTCXXBT")
        val LTCBTC: Pair
    ) {
        data class Pair(
            @SerializedName("a")
            val ask: List<String>?,
            @SerializedName("b")
            val bid: List<String>?,
            @SerializedName("c")
            val last: List<String>?,
            @SerializedName("h")
            val high: List<String>?,
            @SerializedName("l")
            val low: List<String>?,
            @SerializedName("o")
            val open: String?,
            @SerializedName("p")
            val volumeWeighted: List<String>?,
            @SerializedName("t")
            val numTrades: List<Int>?,
            @SerializedName("v")
            val volume: List<String>?
        )

    }
}