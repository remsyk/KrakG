package com.example.krakg.models

import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("numFound")
    var numFound: Int?,
    @SerializedName("start")
    var start: Int?
)