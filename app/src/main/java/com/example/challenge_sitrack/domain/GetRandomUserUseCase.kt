package com.example.challenge_sitrack.domain

import com.example.challenge_sitrack.domain.model.UserInfo
import com.example.challenge_sitrack.utils.Result

class GetRandomUserUseCase (private  val randomUserRepository: RandomUserRepository) {//

    suspend fun getRandomUser(): Result<UserInfo> {
        return randomUserRepository.getRandomUser()
    }
}