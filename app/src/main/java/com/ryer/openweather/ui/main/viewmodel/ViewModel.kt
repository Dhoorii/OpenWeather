package com.ryer.openweather.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ryer.openweather.data.model.WeatherModel
import com.ryer.openweather.data.repository.RoomDataBase
import com.ryer.openweather.data.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    private val repository: WeatherRepository
    private var readAll: LiveData<List<WeatherModel>>
    init {
        val WeatherDB = RoomDataBase.getDatabase(application).WeatherDao()
        repository = WeatherRepository(WeatherDB)
        readAll = repository.getWeatherList()
    }
    fun addWeather(weather: WeatherModel){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertWeather(weather)
        }
    }
    fun deleteAll()
    {
            repository.deleteList()
    }

    fun returnAllWeather(): LiveData<List<WeatherModel>> {
            return repository.getWeatherList()
    }
}