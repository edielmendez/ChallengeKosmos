package mx.com.mvtech.kosmoschallenge.data.common.models

sealed class ServiceResult<out R> {
    data class Success<T>(val data: T): ServiceResult<T>()
    data class Error(val message: String = "") : ServiceResult<Nothing>()
}
