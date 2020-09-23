package com.example.postapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.R
import com.example.postapp.models.Post
class PostsAdapter(
    var posts: List<Post>
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
    )
    override fun getItemCount() = posts.size
    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var post = posts[position]
        holder.itemView.user_id.text = post.userId.toString()
        holder.itemView.idt.text = post.id.toString()
        holder.itemView.title.text = post.title
        holder.itemView.body.text = post.body
    }
    inner class PostsViewHolder(v: View) : RecyclerView.ViewHolder(v)