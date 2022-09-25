package ru.netology.nmedia

import java.util.Calendar.*

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean = false,
    val amountLikes: Int,
    val amountShare: Int,
    val amountViews: Int,
    )