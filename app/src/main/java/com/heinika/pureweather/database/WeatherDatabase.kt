package com.heinika.pureweather.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.heinika.pureweather.entity.Weather

@Database(entities = [Weather::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val weatherDao: WeatherDao
}

private var INSTANCE: WeatherDatabase? = null

fun getInstance(context: Context): WeatherDatabase {
    var instance = INSTANCE
    if (instance == null) {
        synchronized(Weather::class.java) {
            instance = Room.databaseBuilder(
                context,
                WeatherDatabase::class.java,
                "weather_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
    return instance!!
}