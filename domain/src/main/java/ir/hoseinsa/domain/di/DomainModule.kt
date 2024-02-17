package ir.hoseinsa.domain.di

import ir.hoseinsa.domain.repository.UsersRepository
import ir.hoseinsa.domain.usecases.GetUsers
import org.koin.dsl.module

val domainModule = module {
    single<GetUsers> { GetUsers(get()) }
}