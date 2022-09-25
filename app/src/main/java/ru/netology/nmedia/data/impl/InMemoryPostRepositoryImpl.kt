package ru.netology.nmedia.data.impl

import ru.netology.nmedia.Post
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.data.PostRepository

class InMemoryPostRepositoryImpl : PostRepository {

    private var posts = listOf(
        Post(
            id = 5,
            author = "Нетология. Университет интернет=профессий будущего",
            content = "Привет, это новая Нетология!",
            published = "25 мая в 13:36",
            amountLikes = 35,
            amountShare = 1000,
            amountViews = 39,
        ),
        Post(
            id = 4,
            author = "Нетология. Университет интернет=профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы",
            published = "21 мая в 18:36",
            amountLikes = 900,
            amountShare = 10,
            amountViews = 39,
        ),
        Post(
            id = 3,
            author = "Нетология. Университет интернет=профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы",
            published = "21 мая в 18:36",
            amountLikes = 900,
            amountShare = 10,
            amountViews = 39,
        ),
        Post(
            id = 2,
            author = "Нетология. Университет интернет=профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы",
            published = "21 мая в 18:36",
            amountLikes = 900,
            amountShare = 10,
            amountViews = 39,
        ),
        Post(
            id = 1,
            author = "Нетология. Университет интернет=профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы",
            published = "21 мая в 18:36",
            amountLikes = 900,
            amountShare = 10,
            amountViews = 39,
        )
    )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data

    override fun likeById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else{
                it.copy(likedByMe = !it.likedByMe, amountLikes = if (!it.likedByMe) it.amountLikes+1 else it.amountLikes-1)
            }
        }
        data.value = posts
    }

    override fun shareById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(amountShare = it.amountShare+10)
        }
        data.value = posts
    }
}