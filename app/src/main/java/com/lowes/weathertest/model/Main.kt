package com.lowes.weathertest.model


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double = 0.0,
    @SerializedName("grnd_level")
    val grndLevel: Long = 0,
    @SerializedName("humidity")
    val humidity: Long = 0,
    @SerializedName("pressure")
    val pressure: Long = 0,
    @SerializedName("sea_level")
    val seaLevel: Long = 0,
    @SerializedName("temp")
    val temp: Double = 0.0,
    @SerializedName("temp_kf")
    val tempKf: Double = 0.0,
    @SerializedName("temp_max")
    val tempMax: Double = 0.0,
    @SerializedName("temp_min")
    val tempMin: Double = 0.0
)