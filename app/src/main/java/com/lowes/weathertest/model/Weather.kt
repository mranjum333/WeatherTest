package com.lowes.weathertest.model


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("icon")
    val icon: String = "",
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("main")
    val main: String = ""
)