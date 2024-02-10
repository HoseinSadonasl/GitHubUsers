package ir.hoseinsa.githubusers.data.mapper

import ir.hoseinsa.githubusers.domain.models.user.UserItem
import ir.hoseinsa.githubusers.domain.models.user.UserPresenter

fun UserItem.toUserPresenter(): UserPresenter = UserPresenter(
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