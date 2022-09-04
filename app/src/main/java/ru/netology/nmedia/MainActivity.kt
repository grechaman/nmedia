package ru.netology.nmedia

import Post
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет=профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы",
            published = "21 мая в 18:36",
            likedByMe = false
        )

        fun reductionNumber(number: Int): String {
            return when {
                number < 1000 -> "$number"
                number < 10000 && number % 1000 == 0 -> number.toString()[0] + "К"
                number < 10000 -> number.toString()[0] + "." + number.toString()[1] + "К"
                number <1000000 -> number.toString()[0] + "" +number.toString()[1] + "К"
                number <10000000 -> number.toString()[0] + "." +number.toString()[1] + "M"
                else -> number.toString()[0] + "" +number.toString()[1] + "M"
            }
        }

        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            amtLikes.text = post.amountLikes.toString()
            amtShare.text = reductionNumber(post.amountShare)
            amtViews.text = post.amountViews.toString()
            if (post.likedByMe) {
                icLikes.setImageResource(R.drawable.ic_liked_24)

            }

            icLikes.setOnClickListener {
                post.likedByMe = !post.likedByMe
                if (post.likedByMe) post.amountLikes += 1 else post.amountLikes -= 1
                with(binding) {
                    amtLikes.text = post.amountLikes.toString()
                }
                icLikes.setImageResource(
                    if (post.likedByMe) {
                        R.drawable.ic_liked_24
                    } else {
                        R.drawable.ic_likes_24
                    }
                )
            }

            icShare.setOnClickListener {
                post.amountShare += 10
                with(binding) {
                    amtShare.text = reductionNumber(post.amountShare)
                }
            }
        }
    }
}