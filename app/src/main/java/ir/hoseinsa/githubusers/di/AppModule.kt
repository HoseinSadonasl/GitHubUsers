package ir.hoseinsa.githubusers.di

import ir.hoseinsa.githubusers.data.repository.UserRepositoryImpl
import ir.hoseinsa.githubusers.domain.repository.UsersRepository
import ir.hoseinsa.githubusers.domain.usecases.UsersDomain
import org.koin.dsl.module

val appModule = module {
    single<UsersRepository> { UserRepositoryImpl(get()) }
    single<UsersDomain> { UsersDomain(get())}
}