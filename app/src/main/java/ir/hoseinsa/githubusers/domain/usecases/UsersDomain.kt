package ir.hoseinsa.githubusers.domain.usecases

import ir.hoseinsa.githubusers.domain.repository.UsersRepository

data class UsersDomain(
    val users: UsersRepository
)
