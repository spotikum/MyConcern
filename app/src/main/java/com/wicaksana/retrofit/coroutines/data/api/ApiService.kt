package com.wicaksana.retrofit.coroutines.data.api

import com.wicaksana.retrofit.coroutines.data.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

}