package com.example.nba.data.service.helpers

import com.example.nba.data.service.TimeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    companion object{
        //API KEY -> 89998ad4-7af2-4e0e-befb-4f345f0bdded

        private const val BASE_URL = "https://api.balldontlie.io/v1/"

        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory( GsonConverterFactory.create())
            .build()
            .create(TimeApi::class.java)
    }

}