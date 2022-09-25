package ru.netology.nmedia.ui.filesList

import ru.netology.nmedia.Post
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            amtLikes.text = post.amountLikes.toString()
            amtShare.text = reductionNumber(post.amountShare)
            amtViews.text = post.amountViews.toString()
            icLikes.setImageResource(
                if (post.likedByMe) {
                    R.drawable.ic_liked_24
                } else {
                    R.drawable.ic_likes_24
                }
            )
            icLikes.setOnClickListener {
                onLikeListener(post)
            }

            icShare.setOnClickListener {
                onShareListener(post)
            }
        }
    }

    private fun reductionNumber(number: Int): String {
        return when {
            number < 1000 -> "$number"
            number < 10000 && number % 1000 == 0 -> number.toString()[0] + "К"
            number < 10000 -> number.toString()[0] + "." + number.toString()[1] + "К"
            number < 1000000 -> number.toString()[0] + "" + number.toString()[1] + "К"
            number < 10000000 -> number.toString()[0] + "." + number.toString()[1] + "M"
            else -> number.toString()[0] + "" + number.toString()[1] + "M"
        }
    }
}