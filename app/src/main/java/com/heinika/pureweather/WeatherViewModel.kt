package com.heinika.pureweather

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heinika.pureweather.database.getInstance
import com.heinika.pureweather.repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val viewModelJob = SupervisorJob()



    private val viewModeScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = getInstance(application)
    private val weatherRepository = WeatherRepository(database)
    val weathers = weatherRepository.weathers

    init {
        viewModeScope.launch {
            weatherRepository.refresWeather("beijing")
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(private val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
                return WeatherViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}