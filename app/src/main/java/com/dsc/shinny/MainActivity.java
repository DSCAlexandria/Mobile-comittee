package com.dsc.shinny;

import java.util.ArrayList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dsc.shinny.Adapter.ForecastAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Weather> list = createTestList();

        initializeList(list);
    }

    private ArrayList<Weather> createTestList() {
        ArrayList<Weather> list = new ArrayList<>();

        list.add(new Weather("Saturday", "clear", "clear sky", 50, 1000, 0, 19, 40, 35));
        list.add(new Weather("Sunday", "rainy", "heavy rain", 50, 1000, 0, 19, 30, 15));
        list.add(new Weather("Sunday", "rainy", "heavy rain", 50, 1000, 0, 19, 30, 15));
        list.add(new Weather("Sunday", "rainy", "heavy rain", 50, 1000, 0, 19, 30, 15));
        list.add(new Weather("Sunday", "rainy", "heavy rain", 50, 1000, 0, 19, 30, 15));
        list.add(new Weather("Sunday", "rainy", "heavy rain", 50, 1000, 0, 19, 30, 15));
        list.add(new Weather("Sunday", "rainy", "heavy rain", 50, 1000, 0, 19, 30, 15));

        return list;
    }

    private void initializeList(ArrayList<Weather> weatherList) {
        final ForecastAdapter forecastAdapter = new ForecastAdapter(weatherList);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        RecyclerView recyclerView = findViewById(R.id.forecast_list);
        recyclerView.setAdapter(forecastAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


}