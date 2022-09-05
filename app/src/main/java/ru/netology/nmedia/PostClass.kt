import java.util.Calendar.*

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likedByMe: Boolean = false,
    val amountLikes: Int = 10,
    val amountShare: Int = 980,
    val amountViews: Int = 15,

    )