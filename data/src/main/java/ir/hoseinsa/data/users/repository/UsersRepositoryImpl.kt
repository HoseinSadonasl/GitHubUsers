package ir.hoseinsa.data.users.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.hoseinsa.domain.users.model.user.UserItem
import ir.hoseinsa.domain.users.repository.UsersRepository
import ir.hoseinsa.data.remote.GithubApi
import kotlinx.coroutines.flow.Flow

class UsersRepositoryImpl(private val githubApi: GithubApi) : UsersRepository {

    override fun getUsers(): Flow<PagingData<UserItem>> =
        Pager(
            config = PagingConfig(pageSize = 20, initialLoadSize = 30),
            pagingSourceFactory = { UsersDataSource(githubApi) }
        ).flow

}