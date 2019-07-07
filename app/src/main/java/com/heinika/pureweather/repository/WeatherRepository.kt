package com.heinika.pureweather.repository

import com.heinika.pureweather.database.WeatherDatabase
import com.heinika.pureweather.entity.asDatabaseModel
import com.heinika.pureweather.network.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class WeatherRepository(private val database:WeatherDatabase) {
    val weather = database.weatherDao.get()

    suspend fun refresWeather(cityName:String){
        withContext(Dispatchers.IO){
            val weather = WeatherApi.weatherApiService.getWeather(cityName).await()
            database.weatherDao.insert(weather.asDatabaseModel())
        }
    }
}