package ru.netology.nmedia.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelLazy
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels<PostViewModel>()
        viewModel.data.observe(this) { post ->
            with(binding) {
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
                    viewModel.onLikeClicked()
                }

                icShare.setOnClickListener {
                    viewModel.onShareClicked()
                }
            }
        }
    }
}