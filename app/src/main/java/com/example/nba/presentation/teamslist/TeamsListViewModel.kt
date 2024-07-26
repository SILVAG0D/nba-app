package com.example.nba.presentation.teamslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import com.example.nba.data.service.helpers.RetrofitHelper
import kotlinx.coroutines.launch

class TeamsListViewModel : ViewModel() {

    private val apikey = "89998ad4-7af2-4e0e-befb-4f345f0bdded"

    private val retrofit by lazy {
        RetrofitHelper.retrofit
    }

    @UnstableApi
    fun fetchTeams() {
        viewModelScope.launch {
            try {
                Log.d("TeamsListViewModel", "Iniciando a chamada para buscar os times.")
                val response = retrofit.getTeams(apikey)

                if (response.isSuccessful) {
                    val teamsResponse = response.body()
                    val teams = teamsResponse!!.times

                    Log.d("TeamsListViewModel", "Times recebidos com sucesso: $teams")
                } else {
                    Log.d("TeamsListViewModel", "Falha na resposta da API: ${response.errorBody()}")
                }

            } catch (e: Exception) {
                Log.e("TeamsListViewModel", "Erro ao buscar os times: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
