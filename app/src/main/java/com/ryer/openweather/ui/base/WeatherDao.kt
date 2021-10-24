package com.ryer.openweather.ui.base

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ryer.openweather.data.model.WeatherModel

@Dao
interface WeatherDao {
    @Insert
    suspend fun insertWeather(weatherModel: WeatherModel)

    @Update
    suspend fun updateWeather(weatherModel: WeatherModel)

    @Query("SELECT * FROM weather_table ORDER BY weather_table.weather_date DESC LIMIT 10")
    fun getAllWeather(): LiveData<List<WeatherModel>>

    @Query("DELETE FROM weather_table")
    fun deleteAll()
}