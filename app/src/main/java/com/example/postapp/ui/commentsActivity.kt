package com.example.postapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.postapp.R
class CommentsActivity :AppCompatActivity() {
    var postId: Int=0
    Override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState: Bundle?){
            setContentView(R.layout.activity_comments)
            postId=intent.getIntExtra(name:"POST_ID", defaultvalue:0)
        }
    }
}