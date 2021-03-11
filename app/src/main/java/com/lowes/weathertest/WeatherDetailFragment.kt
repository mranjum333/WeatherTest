package com.lowes.weathertest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lowes.weathertest.model.Response
import kotlinx.android.synthetic.main.fragment_weather_detail.*

class WeatherDetailFragment : Fragment() {
    private var response:Response? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        temperature.text = "${response?.main?.temp}"
        feelslike.text = "Feels Like: ${response?.main?.feelsLike}"
        clouds.text = "${response?.weather?.get(0)?.main}"
        brokenClouds.text = "${response?.weather?.get(0)?.description}"
    }


    companion object {
        @JvmStatic
        fun newInstance(response:Response) =
            WeatherDetailFragment().apply {
                this.response = response
                }
            }
}