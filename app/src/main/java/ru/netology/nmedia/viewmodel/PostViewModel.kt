package ru.netology.nmedia.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.data.PostRepository
import ru.netology.nmedia.data.impl.InMemoryPostRepositoryImpl
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.ui.filesList.OnLikeListener

class PostViewModel() : ViewModel() {

    private val repository:PostRepository = InMemoryPostRepositoryImpl()

    val data = repository.getAll()

    fun onLikeClicked(id: Long) = repository.likeById(id)

    fun onShareClicked(id: Long) = repository.shareById(id)
}