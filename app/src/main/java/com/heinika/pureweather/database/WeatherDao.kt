package com.heinika.pureweather.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(databaseWeather: DatabaseWeather)

    @Query("SELECT * FROM WEATHER_TABLE")
    fun get(): DatabaseWeather
}