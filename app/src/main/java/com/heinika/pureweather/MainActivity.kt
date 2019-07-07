package com.heinika.pureweather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.heinika.pureweather.entity.Weather
import com.heinika.pureweather.network.WeatherApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val weatherViewModel:WeatherViewModel by lazy {
        ViewModelProviders.of(this, WeatherViewModel.Factory(application))
            .get(WeatherViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        weatherViewModel.weather.observe(this, Observer { weatherEntity ->
            textView.text = "city: ${weatherEntity.name},weather: ${weatherEntity.temperture}"
        })
        WeatherApi.weatherApiService.getWeather("beijing").enqueue(object: Callback<Weather>{
            override fun onFailure(call: Call<Weather>, t: Throwable) {
                log(t.toString())
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                response.body()?.let {
                    model.weather.value = it
                    log(response.body().toString())
                }
            }
        })
    }

    fun log(message : String){
        Log.i(Companion.TAG,message)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
