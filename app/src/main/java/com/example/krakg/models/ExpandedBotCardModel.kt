package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class ExpandedBotCardModel(
    @SerializedName("title")
    var title: String,
    @SerializedName("value")
    var value: Double,
    @SerializedName("prefix")
    var prefix: String?,
    @SerializedName("suffix")
    var suffix: String?,
    @SerializedName("hasasset")
    var hasasset: Boolean,
    @SerializedName("asset")
    var asset: Unit?
)


