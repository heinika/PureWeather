package com.heinika.pureweather.entity

import com.heinika.pureweather.database.DatabaseWeather

data class Weather(
    val name: String,
    val main: String,//main weather
    val temperature: Double,
    val temp_min:Double,
    val temp_max:Double,
    val humidity: Int,//湿度
    val visibility: Int,
    val pressure: Int,
    val sunrise: Int,
    val sunset: Int,
    val speed: Float,
    val deg: Int
)

fun Weather.asDatabaseModel():DatabaseWeather{
    return DatabaseWeather(name,main,temperature,temp_min,temp_max,humidity,visibility,pressure,sunrise,sunset,speed,deg)
}