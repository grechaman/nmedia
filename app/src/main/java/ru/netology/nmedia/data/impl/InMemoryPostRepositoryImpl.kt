package ru.netology.nmedia.data.impl

import Post
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.data.PostRepository

class InMemoryPostRepositoryImpl : PostRepository {

    private val post: Post
        get() = checkNotNull(data.value) {
            "'data.value' should not be 'null'"
        }

    override val data = MutableLiveData(
        Post(
            id = 1,
            author = "Нетология. Университет интернет=профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы",
            published = "21 мая в 18:36",
        )
    )


    override fun like() {
        val post = post
        data.value = post.copy(
            amountLikes = if (post.likedByMe) post.amountLikes - 1 else post.amountLikes + 1,
            likedByMe = !post.likedByMe
        )
    }

    fun reductionNumber(number: Int): String {
        return when {
            number < 1000 -> "$number"
            number < 10000 && number % 1000 == 0 -> number.toString()[0] + "К"
            number < 10000 -> number.toString()[0] + "." + number.toString()[1] + "К"
            number < 1000000 -> number.toString()[0] + "" + number.toString()[1] + "К"
            number < 10000000 -> number.toString()[0] + "." + number.toString()[1] + "M"
            else -> number.toString()[0] + "" + number.toString()[1] + "M"
        }
    }
    override fun share() {
        val post = post
        data.value = post.copy(amountShare=post.amountShare + 10)
    }
}