package com.example.nba.di
import com.example.nba.data.service.TimeAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class NbaModule {

    private  val BASE_URL = "https://api.balldontlie.io/v1/"

    @Provides
    fun provideRetrofit() : TimeAPI {
         val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
             return retrofit.create(TimeAPI::class.java)
    }


}