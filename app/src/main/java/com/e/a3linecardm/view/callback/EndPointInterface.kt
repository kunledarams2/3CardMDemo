package com.e.a3linecardm.view.callback

import com.e.a3linecardm.view.model.WeatherModel
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface EndPointInterface {


/*
    @Headers("Accept:application/json", "Content-Type:application/x-www-form-urlencoded")
    @GET("faqs/get")
    suspend fun getCurrentWeather(
        @FieldMap params: HashMap<String?,String?>,
        @Header("sessionid") sessionId: String?
    ):Response<ResponseBody> */


    @Headers("Accept:application/json", "Content-Type:application/x-www-form-urlencoded")
    @GET("weather")
    suspend fun getCurrentCityWeather(
        @Query("q") q :String,
        @Query("APPID") appid:String

    ): Response<WeatherModel>

    companion object {

        operator fun invoke(): EndPointInterface {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .build()
                .create(EndPointInterface::class.java)
        }
    }
}