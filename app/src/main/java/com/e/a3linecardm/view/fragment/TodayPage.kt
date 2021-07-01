package com.e.a3linecardm.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.e.a3linecardm.R
import com.e.a3linecardm.view.viewmodel.WeatherViewModel
import kotlinx.coroutines.launch


@SuppressLint("SetTextI18n")
class TodayPage : Fragment() {

    private var weatherViewModel: WeatherViewModel? = null
    lateinit var feelToday: TextView
    lateinit var humdity: TextView
    lateinit var windSpeed: TextView
    lateinit var weatherDescription:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)
        contentView(view)

        return view
    }

    private fun contentView(view: View) {
        feelToday = view.findViewById(R.id.feel_today)
        humdity = view.findViewById(R.id.humidit_tv)
        windSpeed = view.findViewById(R.id.wind_speed)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        weatherViewModel = ViewModelProviders.of(this)[WeatherViewModel::class.java]

        viewLifecycleOwner.lifecycleScope.launch {
            weatherViewModel!!.getCCWeather("Lagos")
        }
        weatherObserver(weatherViewModel!!)

    }

    private fun weatherObserver(weatherViewModel: WeatherViewModel) {
        weatherViewModel.myResponse.observe(viewLifecycleOwner, Observer {
            if (it.isSuccessful) {
                val mainData = it.body()!!.main
                feelToday.text = "${mainData.feels_like}\u2103"
                humdity.text = "${mainData.humidity}%"

                val windData = it.body()!!.wind
                windSpeed.text = "${windData.speed}km"

                val weatherData = it.body()!!.weather
                Log.d("WeatherObj", mainData.toString())

            }
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            TodayPage().apply {
                arguments = Bundle().apply {

                }
            }
    }
}