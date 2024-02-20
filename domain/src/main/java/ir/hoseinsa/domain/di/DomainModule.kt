package ir.hoseinsa.domain.di

import ir.hoseinsa.domain.users.repository.UsersRepository
import ir.hoseinsa.domain.users.usecases.GetUsers
import org.koin.dsl.module

val domainModule = module {
    single<GetUsers> { GetUsers(get()) }
}