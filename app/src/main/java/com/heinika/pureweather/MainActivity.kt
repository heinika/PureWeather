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
        weatherViewModel.weathers.observe(this, Observer { weathers ->
            if(weathers.isNotEmpty()){
                textView.text = "city: ${weathers.get(0).name},weather: ${weathers.get(0).temperture}"
            }
        })
    }

    fun log(message : String){
        Log.i(TAG,message)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
