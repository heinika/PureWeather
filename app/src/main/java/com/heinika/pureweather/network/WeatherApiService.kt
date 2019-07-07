package com.heinika.pureweather.network

import com.heinika.pureweather.json.adapter.WeatherJsonAdapter
import com.heinika.pureweather.entity.Weather
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "http://api.openweathermap.org/data/2.5/"

private const val APP_ID = "11f4cfe45099fd4964754816d482ccad"

private val moshi = Moshi.Builder()
    .add(WeatherJsonAdapter())
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit: Retrofit
    get() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

interface WeatherApiService {
    @GET("weather?appid=$APP_ID&units=metric")
    fun getWeather(@Query("q") cityName: String): Call<Weather>
}

object WeatherApi {
    val weatherApiService: WeatherApiService by lazy { retrofit.create(WeatherApiService::class.java) }
}