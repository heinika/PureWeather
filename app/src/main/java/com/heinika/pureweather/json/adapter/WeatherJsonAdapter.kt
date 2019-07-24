package com.heinika.pureweather.json.adapter

import com.heinika.pureweather.entity.Weather
import com.heinika.pureweather.json.entity.JsonWeatherEntity
import com.squareup.moshi.FromJson

class WeatherJsonAdapter {
    @FromJson
    fun weatherFormJson(jsonWeatherEntity: JsonWeatherEntity): Weather {
        return Weather(
            jsonWeatherEntity.name,
            jsonWeatherEntity.weather[0].main,
            jsonWeatherEntity.main.temp,
            jsonWeatherEntity.main.temp_min,
            jsonWeatherEntity.main.temp_max,
            jsonWeatherEntity.main.humidity,
            jsonWeatherEntity.main.pressure,
            jsonWeatherEntity.visibility,
            jsonWeatherEntity.sys.sunrise,
            jsonWeatherEntity.sys.sunset,
            jsonWeatherEntity.wind.speed,
            jsonWeatherEntity.wind.deg ?: 0
        )
    }
}