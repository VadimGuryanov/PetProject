package kpfu.itis.petproject.api.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: Origin,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val statusStr: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
) {

    val status: Status = when (statusStr) {
        ALIVE -> Status.ALIVE
        DEAD -> Status.DEAD
        else -> Status.UNKNOWN
    }

    companion object {

        private const val ALIVE = "alive"
        private const val DEAD = "dead"
    }
}
