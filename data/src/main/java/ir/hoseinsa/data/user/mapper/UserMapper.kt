package ir.hoseinsa.data.user.mapper

import ir.hoseinsa.data.user.model.UserDto
import ir.hoseinsa.domain.user.model.User

fun UserDto.toUser(): User = User(
    avatarUrl = avatarUrl,
    bio = bio ?: "",
    company = company ?: "",
    createdAt = createdAt,
    email = email ?: "",
    followers = followers,
    following = following,
    hireable = hireable,
    id = id,
    location = location ?: "",
    login = login,
    name = name,
    nodeId = nodeId,
    publicGists = publicGists,
    publicRepos = publicRepos

)