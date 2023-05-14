package com.example.challenge_sitrack.utils

import com.example.challenge_sitrack.domain.model.ResponseApi
import retrofit2.http.GET

interface WebServices {

    @GET("/api/")
    suspend fun getRandomUser(): ResponseApi
}