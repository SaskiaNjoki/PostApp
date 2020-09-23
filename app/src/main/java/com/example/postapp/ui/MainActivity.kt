package com.example.postapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapp.R
import com.example.postapp.repository.PostsRepository
import com.example.postapp.viewmodel.PostsViewModel
import com.example.postapp.viewmodel.PostsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: PostsViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postsViewModelFactory = PostsViewModelFactory(PostsRepository())
        postsViewModel =
            ViewModelProvider(this, postsViewModelFactory).get(PostsViewModel::class.java)
        postsViewModel.getPosts()
        postsViewModel.postsLiveData.observe(this, Observer { posts ->
            if (posts.isEmpty()) {
                postsViewModel.getApiPosts()
            } else {
                val postsAdapter = LinearLayoutManager(baseContext)
                adapter = postsAdapter
            }
        }
    })
    postsViewModel.postsFailedLiveData.observe(this, Observer { error ->
        Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
    })
}
override fun onItemClick(post:post){
    val intent=Intent(baseContext,CommentsActivity::class.java)
    intent.putExtra("POST_ID,post.id")
    startActivity(intent)