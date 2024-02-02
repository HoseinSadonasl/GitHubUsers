package ir.hoseinsa.githubusers.domain.repository

import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun getUsers(): Flow<HttpResponse>

}