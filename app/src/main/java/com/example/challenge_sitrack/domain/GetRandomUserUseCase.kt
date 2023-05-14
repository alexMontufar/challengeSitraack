package com.example.challenge_sitrack.domain

import com.example.challenge_sitrack.domain.model.UserInfo

class GetRandomUserUseCase (private  val randomUserRepository: RandomUserRepository) {//

    suspend fun getRandomUser(): com.example.challenge_sitrack.utils.Result<UserInfo> {
        return randomUserRepository.getRandomUser()
    }
}