package com.wicaksana.retrofit.coroutines.data.repository

import com.wicaksana.retrofit.coroutines.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}