package com.ryer.openweather.data.repository

import androidx.lifecycle.LiveData
import com.ryer.openweather.data.model.WeatherModel
import com.ryer.openweather.ui.base.WeatherDao

class WeatherRepository (private val weatherDao: WeatherDao){

    suspend fun insertWeather(weatherModel: WeatherModel) = weatherDao.insertWeather(weatherModel)

    fun getWeatherList(): LiveData<List<WeatherModel>> = weatherDao.getAllWeather()

    fun deleteList() = weatherDao.deleteAll()

}