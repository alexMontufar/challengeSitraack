package com.example.challenge_sitrack.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge_sitrack.domain.GetRandomUserUseCase
import com.example.challenge_sitrack.domain.model.UserInfo
import com.example.challenge_sitrack.domain.model.toInfoUser
import com.example.challenge_sitrack.ui.model.InfoUser
import com.example.challenge_sitrack.ui.model.MapsUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MapsViewModel(private val getRandomUserUseCase: GetRandomUserUseCase) : ViewModel() {//Clase ViewModel del mapa

    private val _mapsUiModel = MutableLiveData<MapsUiModel>()
    val mapsUiModel: LiveData<MapsUiModel>
        get() = _mapsUiModel

    fun getUser() {//Función para que con el usecase se determine si se obtienen los datos.
        emitMapsUiState(showRefresh = true)
        viewModelScope.launch(Dispatchers.IO) {
            val result = getRandomUserUseCase.getRandomUser()
            withContext(Dispatchers.Main) {
                when(result) {
                    is com.example.challenge_sitrack.utils.Result.Success -> getUserSuccess(result.data)
                    is com.example.challenge_sitrack.utils.Result.Error -> getUserError(result.exception)
                }
            }
        }
    }

    private fun getUserSuccess(userInfo: UserInfo) {//Función para que se obtenga información del usuario.
        emitMapsUiState(infoUser = userInfo.toInfoUser())
    }

    private fun getUserError(exception: Exception) {//Excepción para cuando el llamado del usuario sea erroneo.
        exception.printStackTrace()
        emitMapsUiState(exception = exception)
    }

    private fun emitMapsUiState(showRefresh: Boolean = false, infoUser: InfoUser? = null, exception: Exception? = null) {
        _mapsUiModel.value = MapsUiModel(showRefresh = showRefresh, infoUser = infoUser, exception = exception)
    }
}