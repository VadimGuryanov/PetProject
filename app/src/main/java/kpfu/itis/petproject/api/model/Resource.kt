package kpfu.itis.petproject.api.model

data class Resource<out T>(val status: ResouceStatus, val data: T?, val error: String?) {
    companion object {
        fun <T> success(data: T? = null): Resource<T> {
            return Resource(ResouceStatus.SUCCESS, data, null)
        }

        fun <T> error(error: String, data: T? = null): Resource<T> {
            return Resource(ResouceStatus.ERROR, data, error)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(ResouceStatus.LOADING, data, null)
        }
    }
}

enum class ResouceStatus {
    SUCCESS,
    ERROR,
    LOADING
}
