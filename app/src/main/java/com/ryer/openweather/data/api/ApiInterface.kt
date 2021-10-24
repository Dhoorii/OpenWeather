package com.ryer.openweather.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface
{
    @GET
    fun getDataFromOpenWeather(@Url searchResult: String): Call<DataFromOpenWeather>
}