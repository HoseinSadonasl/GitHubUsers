package ir.hoseinsa.data.users.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.ktor.client.call.body
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.plugins.ResponseException
import ir.hoseinsa.data.remote.GithubApi
import ir.hoseinsa.data.users.mapper.toDomain
import ir.hoseinsa.data.users.model.UsersItemDto
import ir.hoseinsa.domain.users.model.user.UserItem

class UsersDataSource(
    private val api: GithubApi
) : PagingSource<Int, UserItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserItem> {
        val nextPage = params.key ?: START_PAGE
        return try {
            val response = api.getUsers(
            since = nextPage,
            perPage = params.loadSize
        )
            Log.e("::load", "load: ${response.status}", )
            val data = response.body<List<UsersItemDto>>()
            val usersData = data.toDomain()
            LoadResult.Page(
                data = usersData,
                prevKey = null,
                nextKey = if (data.isEmpty()) null else nextPage + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        } catch (exception: ResponseException) {
            LoadResult.Error(exception)
        } catch (exception: ConnectTimeoutException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        const val START_PAGE = 1
    }

}