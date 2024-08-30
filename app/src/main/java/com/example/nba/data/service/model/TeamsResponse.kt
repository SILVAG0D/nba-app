package com.example.nba.data.service.model

import com.example.nba.model.Team
import com.google.gson.annotations.SerializedName

data class TeamsResponse(
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

fun List<TeamsResponse>.toDomain() = map { team ->
    Team(
        abbreviation = team.abbreviation,
        city = team.city,
        conference = team.conference,
        division = team.division,
        full_name = team.full_name,
        id = team.id,
        name = team.name
    )
}