package ir.hoseinsa.githubusers.domain.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserItem(
    @SerialName("avatar_url")
    val avatar_url: String,
    @SerialName("events_url")
    val events_url: String,
    @SerialName("followers_url")
    val followers_url: String,
    @SerialName("following_url")
    val following_url: String,
    @SerialName("gists_url")
    val gists_url: String,
    @SerialName("gravatar_id")
    val gravatar_id: String,
    @SerialName("html_url")
    val html_url: String,
    @SerialName("id")
    val id: Int,
    @SerialName("login")
    val login: String,
    @SerialName("node_id")
    val node_id: String,
    @SerialName("organizations_url")
    val organizations_url: String,
    @SerialName("received_events_url")
    val received_events_url: String,
    @SerialName("repos_url")
    val repos_url: String,
    @SerialName("site_admin")
    val site_admin: Boolean,
    @SerialName("starred_url")
    val starred_url: String,
    @SerialName("subscriptions_url")
    val subscriptions_url: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
)