package com.example.nba.data.service.model

import com.google.gson.annotations.SerializedName

data class TimesModel(

    @SerializedName("data")
    val data: List<TimeModel>
)