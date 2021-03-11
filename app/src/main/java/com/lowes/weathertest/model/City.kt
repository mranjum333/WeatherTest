package com.lowes.weathertest.model


import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord")
    val coord: Coord = Coord(),
    @SerializedName("country")
    val country: String = "",
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("population")
    val population: Long = 0,
    @SerializedName("sunrise")
    val sunrise: Long = 0,
    @SerializedName("sunset")
    val sunset: Long = 0,
    @SerializedName("timezone")
    val timezone: Long = 0
)