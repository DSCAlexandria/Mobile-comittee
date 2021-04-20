package com.dsc.shinny;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsc.shinny.Adapter.ForecastAdapter;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        updateWeather();
    }

    private void updateWeather() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mocki.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherApi service = retrofit.create(WeatherApi.class);
        service.getForecast().enqueue(new Callback<ArrayList<Weather>>() {
            @Override
            public void onResponse(Call<ArrayList<Weather>> call, Response<ArrayList<Weather>> response) {
                updateRecyclerView(response.body());

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ArrayList<Weather>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateRecyclerView(ArrayList<Weather> weatherList) {
        final ForecastAdapter forecastAdapter = new ForecastAdapter(weatherList);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.forecast_list);
        recyclerView.setAdapter(forecastAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}