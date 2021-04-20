package com.dsc.shinny;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {
    @GET("v1/9485cd06-84d4-46c5-bad7-23433d9b6821")
    Call<ArrayList<Weather>> getForecast();
}
