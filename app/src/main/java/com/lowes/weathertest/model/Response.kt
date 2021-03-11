package com.lowes.weathertest.model


import com.google.gson.annotations.SerializedName

data class Response (
    @SerializedName("clouds")
    val clouds: Clouds = Clouds(),
    @SerializedName("dt")
    val dt: Long = 0,
    @SerializedName("dt_txt")
    val dtTxt: String = "",
    @SerializedName("main")
    val main: Main = Main(),
    @SerializedName("pop")
    val pop: Double = 0.0,
    @SerializedName("sys")
    val sys: Sys = Sys(),
    @SerializedName("visibility")
    val visibility: Long = 0,
    @SerializedName("weather")
    val weather: List<Weather> = listOf(),
    @SerializedName("wind")
    val wind: Wind = Wind()
)