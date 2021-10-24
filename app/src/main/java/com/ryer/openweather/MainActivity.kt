package com.ryer.openweather

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ryer.openweather.data.api.ApiClient
import com.ryer.openweather.data.api.DataFromOpenWeather
import com.ryer.openweather.data.model.WeatherModel
import com.ryer.openweather.ui.main.adapter.WeatherListAdapter
import com.ryer.openweather.ui.main.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModel
    lateinit var context: Context
    var listOfWeather: ArrayList<WeatherModel> = ArrayList()
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerViewTemperature)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.returnAllWeather().observe(this, {
            listOfWeather.clear()
            it.forEach{ it ->
                listOfWeather.add(it)
            }
        })
    }

    fun onClickSearch(view: android.view.View) {
        val city = "Katowice"
        context = this
        GlobalScope.launch(Dispatchers.Main) {
            getApi(city)
        }
    }

    private fun getApi(city:String)
    {
        val string = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+ getString(
            R.string.APIKEY)
        val call: Call<DataFromOpenWeather> = ApiClient.getDataFromRetrofit.getDataFromOpenWeather(string)
        call.enqueue(object  : Callback<DataFromOpenWeather>
        {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(
                call: Call<DataFromOpenWeather>,
                response: Response<DataFromOpenWeather>
            ) {
                val mainvalues = response.body()!!.main
                val currentDateTime = LocalDate.now()
                var correctTemp = (mainvalues.temp.toDouble() - 273.15)
                correctTemp = String.format("%.2f",correctTemp).toDouble()
                val weather = WeatherModel(null,correctTemp, currentDateTime)
                recyclerView.adapter = WeatherListAdapter(listOfWeather)
                viewModel.addWeather(weather)
            }
            override fun onFailure(call: Call<DataFromOpenWeather>, t: Throwable) {
            }
        })
    }
}