package com.example.nba.state

sealed class State<out T> {
    data class Sucess<T>(val data: T) : State<T>()
    data class Error<T>(val exeception: Exception) : State<Nothing>()
}