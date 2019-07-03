package com.heinika.pureweather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.heinika.pureweather.entity.WeatherEntity
import com.heinika.pureweather.network.WeatherApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val model = ViewModelProviders.of(this).get(WeatherModel::class.java)
        model.weatherEntity.observe(this, Observer { weatherEntity ->
            textView.text = "city: ${weatherEntity.name},weather: ${weatherEntity.temperture}"
        })
        WeatherApi.weatherApiService.getWeather("beijing").enqueue(object: Callback<WeatherEntity>{
            override fun onFailure(call: Call<WeatherEntity>, t: Throwable) {
                log(t.toString())
            }

            override fun onResponse(call: Call<WeatherEntity>, response: Response<WeatherEntity>) {
                response.body()?.let {
                    model.weatherEntity.value = it
                    log(response.body().toString())
                }
            }
        })
    }

    fun log(message : String){
        Log.i(TAG,message)
    }
}
