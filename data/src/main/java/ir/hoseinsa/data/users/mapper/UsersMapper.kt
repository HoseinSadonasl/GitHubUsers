package ir.hoseinsa.data.users.mapper

import ir.hoseinsa.data.users.model.UsersItemDto
import ir.hoseinsa.domain.users.model.user.UserItem

fun List<UsersItemDto>.toDomain(): List<UserItem> = map { user -> user.toDomain() }

fun UsersItemDto.toDomain(): UserItem = UserItem(
    avatar_url = avatar_url,
    login = login
)