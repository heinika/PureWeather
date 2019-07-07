package com.heinika.pureweather.entity

import com.heinika.pureweather.database.DatabaseWeather

data class Weather(
    val name: String,
    val temperture: Double
)

fun Weather.asDatabaseModel():DatabaseWeather{
    return DatabaseWeather(name,temperture)
}