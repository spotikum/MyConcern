package com.wicaksana.retrofit.coroutines.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getPosts() = apiService.getPosts()
}