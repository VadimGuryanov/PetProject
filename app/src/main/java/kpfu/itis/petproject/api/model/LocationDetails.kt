package kpfu.itis.petproject.api.model

data class LocationDetails(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<Any>,
    val type: String,
    val url: String
)
