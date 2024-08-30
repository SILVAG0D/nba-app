package com.example.nba.data.service.model

import com.google.gson.annotations.SerializedName

data class TimeModel(
    @SerializedName("data")
    val data: List<Data>
)