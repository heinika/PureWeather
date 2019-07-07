package com.heinika.pureweather.json.adapter

import com.heinika.pureweather.entity.Weather
import com.heinika.pureweather.json.entity.JsonWeatherEntity
import com.squareup.moshi.FromJson

class WeatherJsonAdapter {
    @FromJson
    fun weatherFormJson(jsonWeatherEntity: JsonWeatherEntity):Weather{
        return Weather(jsonWeatherEntity.name,jsonWeatherEntity.main.temp)
    }
}