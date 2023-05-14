package com.example.challenge_sitrack.utils

sealed class Result<out T : Any> {//Clase sellada para determinar si es correcta o incorrecta la llamada.

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
