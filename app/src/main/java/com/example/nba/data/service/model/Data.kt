package com.example.nba.data.service.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("conference")
    val conference: String,
    @SerializedName("division")
    val division: String,
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)