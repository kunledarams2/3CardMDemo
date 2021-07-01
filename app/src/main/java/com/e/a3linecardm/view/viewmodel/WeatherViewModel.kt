package com.e.a3linecardm.view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e.a3linecardm.view.model.WeatherModel
import com.e.a3linecardm.view.repository.WeatherRepository
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response

class WeatherViewModel: ViewModel() {


    var myResponse : MutableLiveData<Response<WeatherModel>> = MutableLiveData()
    private val repository : WeatherRepository = WeatherRepository()

    fun getCCWeather(city: String){

        viewModelScope.launch {
            val response = repository.getCityCurrentWeather(city)
            Log.d("WeatherViewModel", response.toString())

            myResponse.value = response
        }
    }
}