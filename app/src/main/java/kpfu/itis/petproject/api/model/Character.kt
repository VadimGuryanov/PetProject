package kpfu.itis.petproject.api.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("created")
    var created: String,
    @SerializedName("episode")
    var episode: List<String>,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("location")
    var location: Location,
    @SerializedName("name")
    var name: String,
    @SerializedName("origin")
    var origin: Origin,
    @SerializedName("species")
    var species: String,
    @SerializedName("status")
    var statusStr: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("url")
    var url: String
) {

//    val status = when (statusStr) {
//        ALIVE -> Status.ALIVE
//        DEAD -> Status.DEAD
//        else -> Status.UNKNOWN
//    }

    companion object {

        private const val ALIVE = "Alive"
        private const val DEAD = "Dead"
    }
}
