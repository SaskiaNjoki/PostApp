package com.example.postapp.repository

class PostsRepository() {
    suspend fun getPosts(): Response<List<Post>> = withContext(Dispatchers.IO + NonCancellable) {
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getPosts()
        return@withContext response
    }
}