package com.wicaksana.retrofit.coroutines.data.api

import com.wicaksana.retrofit.coroutines.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}