package com.heinika.pureweather.entity

import com.heinika.pureweather.database.DatabaseWeather

data class Weather(
    val name: String,
    val temperture: Double,
    val main: String,//main weather
    val humidity: Int,//湿度
    val temp_min:Double,
    val temp_max:Double,
    val visibility: Int,
    val sunrise: Int,
    val sunset: Int,
    val speed: Float,
    val deg: Int
)

fun Weather.asDatabaseModel():DatabaseWeather{
    return DatabaseWeather(name,temperture)
}