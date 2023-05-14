package com.example.challenge_sitrack.domain

import com.example.challenge_sitrack.datasource.RandomUserRemoteDataSource

class RandomUserRepository(private val randomUserRemoteDataSource: RandomUserRemoteDataSource) {

    suspend fun getRandomUser() = randomUserRemoteDataSource.getRandomUser()

}