package ir.hoseinsa.presenter.datastate

sealed class DataState<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : DataState<T>(data = data)
    class Error<T>(message: String, data: T? = null) : DataState<T>(data, message)

}