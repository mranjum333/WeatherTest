package com.lowes.weathertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lowes.weathertest.model.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.View {
    val presenter:MainActivityContract.Presenter = MainActivityPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.start(this)
    }

    fun lookUpClicked(view: View) {
        presenter.retrieveWeatherDetails(cityName.text.toString())
    }

    override fun loadList(list: List<Response>){
        val fragment = ResponseFragment.newInstance(list)
        weather_list_holder.visibility = View.VISIBLE
        cityName.visibility = View.GONE
        lookup_button.visibility = View.GONE
        if(supportFragmentManager.findFragmentByTag(ResponseFragment::class.java.simpleName) == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.weather_list_holder,fragment,ResponseFragment::class.java.simpleName)
                .addToBackStack(ResponseFragment::class.java.simpleName)
                .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val count = supportFragmentManager.backStackEntryCount
        val fragmentManager = supportFragmentManager
        val backEntry = supportFragmentManager.getBackStackEntryAt(count - 1)
        val fragmentTag = backEntry.name
        if(fragmentTag != null){
            when(fragmentTag){
                ResponseFragment::class.java.simpleName -> {
                    weather_list_holder.visibility = View.GONE
                    cityName.visibility = View.VISIBLE
                    lookup_button.visibility = View.VISIBLE
                }
                WeatherDetailFragment::class.java.simpleName -> {
                    fragmentManager.popBackStack()
                }
            }
        }

    }
}