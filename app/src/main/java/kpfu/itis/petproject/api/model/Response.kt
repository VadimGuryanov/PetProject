package kpfu.itis.petproject.api.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("info")
    var info: Info,
    @SerializedName("results")
    var results: List<Character>
)
