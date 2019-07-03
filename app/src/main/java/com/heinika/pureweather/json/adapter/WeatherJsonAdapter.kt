package com.heinika.pureweather.json.adapter

import com.heinika.pureweather.entity.WeatherEntity
import com.heinika.pureweather.json.entity.JsonWeatherEntity
import com.squareup.moshi.FromJson

class WeatherJsonAdapter {
    @FromJson
    fun weatherFormJson(jsonWeatherEntity: JsonWeatherEntity):WeatherEntity{
        return WeatherEntity(jsonWeatherEntity.name,jsonWeatherEntity.main.temp)
    }
}