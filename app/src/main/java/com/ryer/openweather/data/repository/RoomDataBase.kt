package com.ryer.openweather.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ryer.openweather.data.model.WeatherModel
import com.ryer.openweather.ui.base.WeatherDao

@Database(
    entities = [WeatherModel::class],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun WeatherDao(): WeatherDao

    companion object{
        @Volatile
        private var INSTANCE: RoomDataBase? = null

        fun getDatabase(context: Context): RoomDataBase{
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDataBase::class.java,
                    "room_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}