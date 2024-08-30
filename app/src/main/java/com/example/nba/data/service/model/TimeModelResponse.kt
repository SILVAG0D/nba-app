package com.example.nba.data.service.model

import com.google.gson.annotations.SerializedName

data class TimeModelResponse(
    @SerializedName("data")
    val data: List<TeamsResponse>
)