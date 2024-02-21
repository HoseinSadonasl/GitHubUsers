package ir.hoseinsa.domain.user.model

data class User(
    val avatarUrl: String,
    val bio: String,
    val company: String,
    val createdAt: String,
    val email: String,
    val followers: Int,
    val following: Int,
    val hireable: Boolean,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    val nodeId: String,
    val publicGists: Int,
    val publicRepos: Int
)