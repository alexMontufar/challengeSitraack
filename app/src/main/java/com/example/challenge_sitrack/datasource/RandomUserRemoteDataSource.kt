package com.example.challenge_sitrack.datasource

import com.example.challenge_sitrack.utils.Result
import com.example.challenge_sitrack.utils.WebServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RandomUserRemoteDataSource {

    suspend fun getRandomUser() = try {
        val retrofit = Retrofit.Builder().baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()
        val webServices: WebServices = retrofit.create(WebServices::class.java)

        val result = webServices.getRandomUser()
        Result.Success(result.userInfo[0])
    } catch (exception: Exception) {
        Result.Error(exception)
    }

    private fun getOkHttpClient() = OkHttpClient.Builder().apply {
        addInterceptor(getHttpInterceptor())
    }.build()

    private fun getHttpInterceptor() = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}
