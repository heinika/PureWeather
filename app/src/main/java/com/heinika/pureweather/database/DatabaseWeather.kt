package com.heinika.pureweather.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class DatabaseWeather(
    @PrimaryKey
    val name: String,
    val temperture: Double
)