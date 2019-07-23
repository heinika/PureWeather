package com.heinika.pureweather.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.heinika.pureweather.entity.Weather

@Entity(tableName = "weather_table")
data class DatabaseWeather(
    @PrimaryKey
    val name: String,
    val main: String,//main weather
    val temperature: Double,
    val temp_min: Double,
    val temp_max: Double,
    val humidity: Int,
    val visibility: Int,
    val pressure: Int,
    val sunrise: Long,
    val sunset: Long,
    val speed: Float,
    val deg: Int
)

fun List<DatabaseWeather>.asModel(): List<Weather> {
    return map {
        Weather(
            name = it.name,
            main = it.main,
            temperature = it.temperature,
            temp_min = it.temp_min,
            temp_max = it.temp_max,
            humidity = it.humidity,
            visibility = it.visibility,
            pressure = it.pressure,
            sunrise = it.sunrise,
            sunset = it.sunset,
            speed = it.speed,
            deg = it.deg
        )
    }
}