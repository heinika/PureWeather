package com.heinika.pureweather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heinika.pureweather.entity.WeatherEntity

class WeatherModel : ViewModel() {
    val weatherEntity : MutableLiveData<WeatherEntity> = MutableLiveData();
}