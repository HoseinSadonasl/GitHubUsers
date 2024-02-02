package ir.hoseinsa.githubusers.data.repository

import io.ktor.client.statement.HttpResponse
import ir.hoseinsa.githubusers.data.api.UsersApi
import ir.hoseinsa.githubusers.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(val api: UsersApi): UsersRepository {

    override suspend fun getUsers(): Flow<HttpResponse> = flow {
        emit(api.getUsers())
    }

}