package ir.hoseinsa.data.users.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import ir.hoseinsa.data.remote.GithubApi
import ir.hoseinsa.data.users.mapper.toUsersItem
import ir.hoseinsa.data.users.model.UsersItemDto
import ir.hoseinsa.domain.users.model.user.UserItem

class UsersDataSource(
    private val api: GithubApi
) : PagingSource<Int, UserItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserItem> {
        val nextPage = params.key ?: START_PAGE
        return try {
            val response = api.getUsers(since = nextPage, perPage = params.loadSize)
            val data = response.body<List<UsersItemDto>>()
            val usersData = data.toUsersItem()
            LoadResult.Page(data = usersData, prevKey = null, nextPage)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        } catch (exception: ClientRequestException) {
            LoadResult.Error(exception)
        } catch (exception: ServerResponseException) {
            LoadResult.Error(exception)
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserItem>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    companion object {
        const val START_PAGE = 1
    }

}