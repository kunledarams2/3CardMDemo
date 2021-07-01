package com.e.a3linecardm.view.repository

import com.e.a3linecardm.view.callback.EndPointInterface
import com.e.a3linecardm.view.io.Constant
import com.e.a3linecardm.view.model.WeatherModel
import okhttp3.ResponseBody
import retrofit2.Response

class WeatherRepository {

    suspend fun getCityCurrentWeather(city:String): Response<WeatherModel> {
        val params = HashMap<String, String>()
        params["q"] = city
        params["appid"] = Constant.WEATHER_API_KEY
        return EndPointInterface().getCurrentCityWeather(city, Constant.WEATHER_API_KEY )}
}