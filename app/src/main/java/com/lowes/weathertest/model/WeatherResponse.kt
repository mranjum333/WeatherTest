package com.lowes.weathertest.model


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("city")
    val city: City = City(),
    @SerializedName("cnt")
    val cnt: Long = 0,
    @SerializedName("cod")
    val cod: String = "",
    @SerializedName("list")
    val list: List<Response> = listOf(),
    @SerializedName("message")
    val message: Long = 0
)