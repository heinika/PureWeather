package com.heinika.pureweather.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.heinika.pureweather.database.WeatherDatabase
import com.heinika.pureweather.database.asModel
import com.heinika.pureweather.entity.Weather
import com.heinika.pureweather.entity.asDatabaseModel
import com.heinika.pureweather.network.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class WeatherRepository(private val database: WeatherDatabase) {
    val weathers: LiveData<List<Weather>> =
        Transformations.map(database.weatherDao.getWeathers()) {
            it.asModel()
        }

    suspend fun refresWeather(cityName: String) {
        withContext(Dispatchers.IO) {
            val weather = WeatherApi.weatherApiService.getWeather(cityName).await()
            database.weatherDao.insert(weather.asDatabaseModel())
        }
    }
}