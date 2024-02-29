package ir.hoseinsa.data.user.mapper

import ir.hoseinsa.data.user.model.UserDto
import ir.hoseinsa.domain.user.model.User

fun UserDto.toUser(): User = User(
    avatarUrl = avatarUrl,
    bio = bio,
    followers = followers,
    following = following,
    login = login,
    name = name
)