package ru.netology.nmedia.data

import ru.netology.nmedia.Post
import androidx.lifecycle.LiveData

interface PostRepository {

    fun getAll(): LiveData<List<Post>>

    fun likeById(id: Long)

    fun shareById(id: Long)

}