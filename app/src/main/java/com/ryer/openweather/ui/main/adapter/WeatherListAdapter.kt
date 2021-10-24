package com.ryer.openweather.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ryer.openweather.R
import com.ryer.openweather.data.model.WeatherModel

class WeatherListAdapter(private val itemList: ArrayList<WeatherModel>) : RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.weather_item,
        parent,false)
        return WeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currectItem = itemList[position]
        holder.itemTemp.text = currectItem.temp.toString()
        holder.itemDate.text = currectItem.weatherDate.toString()
    }

    override fun getItemCount() = itemList.size


    class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemTemp: TextView = itemView.findViewById(R.id.item_temperature)
        val itemDate: TextView = itemView.findViewById(R.id.item_date)
    }
}