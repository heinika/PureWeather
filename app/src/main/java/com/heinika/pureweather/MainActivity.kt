package com.heinika.pureweather

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.heinika.pureweather.entity.formatSunrise
import com.heinika.pureweather.entity.formatSunset
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by lazy {
        ViewModelProviders.of(this, WeatherViewModel.Factory(application))
            .get(WeatherViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weatherViewModel.weathers.observe(this, Observer { weathers ->
            if (weathers.isNotEmpty()) {
                textViewtemperature.text = weathers[0].temperature.toString() + "℃"
                textViewMaxTemperature.text = weathers[0].temp_max.toString() + "℃"
                textViewMinTemperature.text = weathers[0].temp_min.toString() + "℃"
                textViewCityName.text = weathers[0].name
                textViewSunriseTime.text = weathers[0].formatSunrise
                textViewSunsetTime.text = weathers[0].formatSunset
//                textViewtemperature.text = "name: ${weathers[0].name},\n" +
//                        "main: ${weathers[0].main},\n" +
//                        "temperature: ${weathers[0].temperature},\n" +
//                        "temp_min: ${weathers[0].temp_min},\n" +
//                        "temp_max: ${weathers[0].temp_max},\n" +
//                        "humidity: ${weathers[0].humidity},\n" +
//                        "visibility: ${weathers[0].visibility},\n" +
//                        "pressure: ${weathers[0].pressure},\n" +
//                        "sunrise: ${weathers[0].sunrise},\n" +
//                        "sunset: ${weathers[0].sunset},\n" +
//                        "speed: ${weathers[0].speed},\n" +
//                        "deg: ${weathers[0].deg}"
            }
        })
    }

    fun log(message: String) {
        Log.i(TAG, message)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
