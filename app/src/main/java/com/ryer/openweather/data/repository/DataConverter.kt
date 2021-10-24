package com.ryer.openweather.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate

class DateConverter {

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toDate(timestamp: String): LocalDate {
        val array = timestamp.split("-").toTypedArray()
        return LocalDate.of(array[0].toInt(), array[1].toInt(), array[2].toInt())
    }

    @TypeConverter
    fun toTimestamp(date: LocalDate): String {
        return date.toString()
    }
}