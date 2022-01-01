package com.wicaksana.retrofit.coroutines.data.api

import com.wicaksana.retrofit.coroutines.data.model.Post
import com.wicaksana.retrofit.coroutines.data.model.ResponseYahooStatis
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @FormUrlEncoded
    @POST("v0/yahoo")
    fun postYahooStatis(
        @Field("category") category: String,
        @Field("type") type: String,
        @Field("value") value: Int
    ): Call<ResponseYahooStatis>
}