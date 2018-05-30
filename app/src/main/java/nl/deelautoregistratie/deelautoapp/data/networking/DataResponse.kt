package nl.deelautoregistratie.deelautoapp.data.networking

sealed class DataResponse<T>{
    data class Progress<T>(var loading: Boolean) : DataResponse<T>()
    data class Success<T>(var data: T) : DataResponse<T>()
    data class Failure<T>(val e: Throwable) : DataResponse<T>()

    companion object {
        fun <T> loading(isLoading: Boolean): DataResponse<T> = Progress(isLoading)

        fun <T> success(data: T): DataResponse<T> = Success(data)

        fun <T> failure(e: Throwable): DataResponse<T> = Failure(e)
    }
}