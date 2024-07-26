package com.example.nba.data.service

import com.example.nba.data.service.model.TimeModel
import com.example.nba.data.service.model.TimesModel
import com.google.android.gms.common.api.internal.ApiKey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TimeApi {

    @GET("teams")
    suspend fun getTeams(
        @Header("Authorization")
        apiKey: String): Response<TimesModel>
}