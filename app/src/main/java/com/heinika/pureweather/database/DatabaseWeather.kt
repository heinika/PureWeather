package com.heinika.pureweather.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.heinika.pureweather.entity.Weather

@Entity(tableName = "weather_table")
data class DatabaseWeather(
    @PrimaryKey
    val name: String,
    val temperture: Double
)

fun DatabaseWeather.asModel():Weather{
    return Weather(name,temperture)
}

fun List<DatabaseWeather>.asModel(): List<Weather> {
    return map {
        Weather(
            name = it.name,
            temperture = it.temperture
        )
    }
}