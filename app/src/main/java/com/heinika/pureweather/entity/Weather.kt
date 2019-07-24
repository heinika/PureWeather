package com.heinika.pureweather.entity

import com.heinika.pureweather.database.DatabaseWeather
import java.text.SimpleDateFormat
import java.util.*

data class Weather(
    val name: String,
    val main: String,//main weather
    val temperature: Double,
    val temp_min: Double,
    val temp_max: Double,
    val humidity: Int,//湿度
    val visibility: Int,
    val pressure: Int,
    val sunrise: Long,
    val sunset: Long,
    val speed: Float,
    val deg: Int
)

fun Weather.asDatabaseModel(): DatabaseWeather {
    return DatabaseWeather(
        name,
        main,
        temperature,
        temp_min,
        temp_max,
        humidity,
        visibility,
        pressure,
        sunrise,
        sunset,
        speed,
        deg
    )
}

val Weather.formatSunrise: String
    get() {
        val sunriseData = Date(sunrise * 1000)
        val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())
        return sdf.format(sunriseData)
    }

val Weather.formatSunset: String
    get() {
        val sunsetData = Date(sunset * 1000)
        val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())
        return sdf.format(sunsetData)
    }

