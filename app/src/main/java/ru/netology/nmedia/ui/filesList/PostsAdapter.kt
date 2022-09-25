package ru.netology.nmedia.ui.filesList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.netology.nmedia.Post
import ru.netology.nmedia.databinding.CardPostBinding

typealias OnLikeListener = (post: Post) -> Unit

class PostsAdapter(private val onLikeListener: OnLikeListener) :
    ListAdapter<Post, PostViewHolder>(PostDiffCallback()) {
    var list = emptyList<Post>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onLikeListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position]
        holder.bind(post)
    }

}