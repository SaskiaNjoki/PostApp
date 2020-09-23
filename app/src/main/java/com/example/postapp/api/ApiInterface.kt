package com.example.postapp.api

import com.example.postapp.models.Post
interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}