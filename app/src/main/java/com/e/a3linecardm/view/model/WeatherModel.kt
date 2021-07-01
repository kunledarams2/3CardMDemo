package com.e.a3linecardm.view.model

import org.json.JSONObject

/*{"coord":{"lon":3.75,"lat":6.5833},"weather":[{"id":804,"main":"Clouds","description":"overcast clouds","icon":"04n"}],"base":"stations",
"main":{"temp":299.33,"feels_like":299.33,"temp_min":299.33,"temp_max":299.33,"pressure":1014,"humidity":91,"sea_level":1014,"grnd_level":1014},"visibility":10000,
"wind":{"speed":1.5,"deg":260,"gust":2.68},"clouds":{"all":87},"dt":1625111558,"sys":{"type":1,"id":1185,"country":"NG","sunrise":1625117628,"sunset":1625162619},"timezone":3600,"id":2332453,"name":"Lagos","cod":200}*/

data class WeatherModel(

    var weather: List<WeatherData>,
    var main: MainData,
    var visibility:String,
    var wind :WindData

)

data class WeatherData(
    var id:Int,
    var description :String
)


data class MainData(
    var temp:String,
    var feels_like:String,
    var humidity:String

)
data class WindData(var speed : String, var deg:String)