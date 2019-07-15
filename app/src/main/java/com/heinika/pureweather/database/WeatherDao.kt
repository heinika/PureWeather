package com.heinika.pureweather.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(databaseWeather: DatabaseWeather)

    @Query("SELECT * FROM weather_table")
    fun getWeathers(): LiveData<List<DatabaseWeather>>
}