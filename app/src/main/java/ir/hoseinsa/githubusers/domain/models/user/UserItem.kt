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
) {
    fun toUserPresenter(): UserPresenter = UserPresenter(
        avatar_url = avatar_url,
        events_url = events_url,
        followers_url = followers_url,
        following_url = following_url,
        gists_url = gists_url,
        gravatar_id = gravatar_id,
        html_url = html_url,
        id = id,
        login = login,
        node_id = node_id,
        organizations_url = organizations_url,
        received_events_url = received_events_url,
        repos_url = repos_url,
        site_admin = site_admin,
        starred_url = starred_url,
        subscriptions_url = subscriptions_url,
        type = type,
        url = url
    )
}