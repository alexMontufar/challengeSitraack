package com.example.challenge_sitrack.domain

import com.example.challenge_sitrack.datasource.RandomUserRemoteDataSource

class RandomUserRepository(private val randomUserRemoteDataSource: RandomUserRemoteDataSource) {//Repositorio para enviar información al viewmodel.

    suspend fun getRandomUser() = randomUserRemoteDataSource.getRandomUser()

}