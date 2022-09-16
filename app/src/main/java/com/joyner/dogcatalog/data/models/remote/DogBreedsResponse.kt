package com.joyner.dogcatalog.data.models.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DogBreedsResponse(
    @field:Json(name = "status")
    val status: String,
    @field:Json(name = "message")
    val breeds: Breeds
){

    @JsonClass(generateAdapter = true)
    data class Breeds(
        @field:Json(name = "affenpinscher")
        val affenpinscher: List<String>,
        @field:Json(name = "african")
        val african: List<String>,
        @field:Json(name = "airedale")
        val airedale: List<String>,
        @field:Json(name = "akita")
        val akita: List<String>,
        @field:Json(name = "appenzeller")
        val appenzeller: List<String>,
        @field:Json(name = "australian")
        val australian: List<String>,
        @field:Json(name = "basenji")
        val basenji: List<String>,
        @field:Json(name = "buhund")
        val buhund: List<String>,
        @field:Json(name = "bulldog")
        val bulldog: List<String>,
        @field:Json(name = "bullterrier")
        val bullterrier: List<String>,
        @field:Json(name = "hound")
        val hound: List<String>,
        @field:Json(name = "terrier")
        val terrier: List<String>,
    )
}
