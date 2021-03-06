package com.example.postapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.postapp.models.Post
import com.example.postapp.repository.PostsRepository
class PostsViewModel(val postsRepository: PostsRepository) : ViewModel() {
    var postsLiveData = MutableLiveData<List<Post>>()
    var postsFailedLiveData = MutableLiveData<String>()
    fun getPosts() {
        viewModelScope.launch {
            val response = postsRepository.getPosts()
            if (response.isSuccessful) {
                postsLiveData.postValue(response.body())
            } else {
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
}





