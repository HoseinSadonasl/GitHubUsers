package ir.hoseinsa.githubusers.data.di

import io.ktor.client.HttpClient
import ir.hoseinsa.data.remote.githubClient
import ir.hoseinsa.data.user.repository.UserRepositoryImpl
import ir.hoseinsa.domain.user.repository.UserRepository
import ir.hoseinsa.domain.users.repository.UsersRepository
import ir.hoseinsa.githubusers.data.remote.GithubApi
import ir.hoseinsa.githubusers.data.repository.UsersRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<HttpClient> { githubClient() }
    single<GithubApi> { GithubApi(get()) }
    single<UsersRepository> { UsersRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}