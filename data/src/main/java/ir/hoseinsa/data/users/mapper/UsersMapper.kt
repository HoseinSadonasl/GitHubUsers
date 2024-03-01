package ir.hoseinsa.data.users.mapper

import ir.hoseinsa.data.users.model.UsersItemDto
import ir.hoseinsa.domain.users.model.user.UserItem

fun List<UsersItemDto>.toUsersItem(): List<UserItem> = map { user -> user.toUser() }

fun UsersItemDto.toUser(): UserItem = UserItem(
    avatar_url = avatar_url,
    login = login
)