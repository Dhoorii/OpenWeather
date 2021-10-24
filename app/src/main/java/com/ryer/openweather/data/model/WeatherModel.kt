package com.ryer.openweather.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "weather_table")
data class WeatherModel(
    @PrimaryKey(autoGenerate = true) val weatherID: Int?,
    @ColumnInfo(name = "weather_temp") val temp: Double?,
    @ColumnInfo(name = "weather_date") val weatherDate: LocalDate
        )

