package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class IndicatorGuideModel(
    @SerializedName("title")
    var title: String,
    @SerializedName("detail")
    var detail: String
)


