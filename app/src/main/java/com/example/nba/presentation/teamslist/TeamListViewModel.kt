package com.example.nba.presentation.teamslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nba.data.service.TimeAPI
import com.example.nba.data.service.helpers.RetrofitInstance
import com.example.nba.data.service.model.toDomain
import com.example.nba.model.Team
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class State {
    data object Loading : State()
    data class Success(val times: List<Team>) : State()
    data class Error(val message: String) : State()
}

class TeamListViewModel : ViewModel() {

    private val _screenState = MutableStateFlow<State>(State.Loading)
    val state = _screenState.asStateFlow()

    init {
        getTeamsList()
    }

    private fun getTeamsList() {
        viewModelScope.launch {
            getTimes()
        }
    }

    private suspend fun getTimes() {
        _screenState.update { State.Loading }

        val retrofit by lazy {
            RetrofitInstance.retrofit
        }
        val apiKey = "89998ad4-7af2-4e0e-befb-4f345f0bdded"

        try {
            val teamApi = retrofit.create(TimeAPI::class.java)
            val response = teamApi.getTimes(apiKey)

            if (response.isSuccessful) {
                val body = response.body()?.data?.toDomain()
                if (body != null) {
                    _screenState.update {
                        State.Success(body)
                    }
                } else {
                    _screenState.update {
                        State.Error(response.message())
                    }
                }
            } else {
                _screenState.update {
                    State.Error(response.message())
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()

            _screenState.update {
                State.Error(e.message ?: "")
            }
        }
    }
}