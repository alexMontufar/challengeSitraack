package com.example.challenge_sitrack.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challenge_sitrack.datasource.RandomUserRemoteDataSource
import com.example.challenge_sitrack.domain.GetRandomUserUseCase
import com.example.challenge_sitrack.domain.RandomUserRepository
import com.example.challenge_sitrack.ui.MapsViewModel

@Suppress("UNCHECKED_CAST")
class MapsViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MapsViewModel::class.java)) {
            return MapsViewModel(
                    getRandomUserUseCase = GetRandomUserUseCase(
                            randomUserRepository = RandomUserRepository(
                                    randomUserRemoteDataSource = RandomUserRemoteDataSource()
                            )
                    )
            ) as T
        }
        throw java.lang.IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }
}