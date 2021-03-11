package com.lowes.weathertest.api

import com.lowes.weathertest.model.WeatherResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
private const val APP_ID = "65d00499677e59496ca2f318eb68c049"
interface WeatherApi {
    @GET("forecast")
    fun getForecastForZipCode(@Query("q") city: String, @Query("appid") appid:String = APP_ID): Observable<WeatherResponse>
}