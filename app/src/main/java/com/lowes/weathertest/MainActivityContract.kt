package com.lowes.weathertest

import com.lowes.weathertest.model.Response

interface MainActivityContract {
    interface View{
        fun loadList(list: List<Response>)
    }
    interface Presenter{
        fun start(view:MainActivityContract.View)
        fun retrieveWeatherDetails(city:String)
    }
}