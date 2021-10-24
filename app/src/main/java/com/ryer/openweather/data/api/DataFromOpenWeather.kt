package com.ryer.openweather.data.api

import com.google.gson.annotations.SerializedName
//Topic Structure

data class DataFromOpenWeather(
    @SerializedName("coord")
    val coord: Coords,
    @SerializedName("main")
    val main:MainWeather,
    @SerializedName("visibility")
    val visibility:String,
    @SerializedName("wind")
    val wind:Wind,
    @SerializedName("clouds")
    val clouds:Clouds,
    @SerializedName("sys")
    val sys:Sys,
    @SerializedName("timezone")
    val timezone:String
)

//Article Structure
data class Coords(
    @SerializedName("lon")
    val lon: String,
    @SerializedName("lat")
    val lat:String)

data class MainWeather(
    @SerializedName("temp")
    val temp: String,
    @SerializedName("feels_like")
    val feels_like: String,
    @SerializedName("temp_min")
    val temp_min: String,
    @SerializedName("temp_max")
    val temp_max: String,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("humidity")
    val humidity: String,
)

data class Wind(
    @SerializedName("speed")
    val speed: String,
    @SerializedName("deg")
    val deg: String,
    @SerializedName("gust")
    val gust: String
)

data class Clouds(
    @SerializedName("all")
    val all: String
)

data class Sys(
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("sunrise")
    val sunrise: String,
    @SerializedName("sunset")
    val sunset: String
)