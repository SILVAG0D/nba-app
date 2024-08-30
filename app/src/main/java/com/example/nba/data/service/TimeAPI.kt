package com.example.nba.data.service

import com.example.nba.data.service.model.TimeModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TimeAPI {

    @GET("teams")
    suspend fun getTimes(
        @Header("Authorization")
        apiKey: String
    ): Response<TimeModelResponse>
}