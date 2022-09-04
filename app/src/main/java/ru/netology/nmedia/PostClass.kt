import java.util.Calendar.*

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean = false,
    var amountLikes: Int = 10,
    var amountShare: Int = 980,
    var amountViews: Int = 15,

    )