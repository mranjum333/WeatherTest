package com.lowes.weathertest

import com.lowes.weathertest.api.WeatherApiManager
import com.lowes.weathertest.model.WeatherResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivityPresenter : MainActivityContract.Presenter {

    private var view:MainActivityContract.View? = null
    override fun start(view: MainActivityContract.View) {
      this.view = view
    }

    override fun retrieveWeatherDetails(city:String) {
       val response =  WeatherApiManager().createWeatherApi().getForecastForZipCode(city)
         response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Observer<WeatherResponse>{
                override fun onComplete() = Unit

                override fun onSubscribe(d: Disposable) = Unit

                override fun onNext(t: WeatherResponse) {
                    print("onNext")
                    print("================= ${t.city.name} ${t.city.id}")
                    view?.loadList(t.list)
                }

                override fun onError(e: Throwable) {
                  print("Failed to retrieve data ")
                }

            })
    }
}