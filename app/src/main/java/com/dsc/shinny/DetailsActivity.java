package com.dsc.shinny;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    public static final String KEY = "clickedForecast_Data";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Weather weatherObj = (Weather) getIntent().getSerializableExtra(KEY);

        ImageView image = findViewById(R.id.icon_details);
        image.setImageResource(weatherObj.getIconResId());

        TextView dayName = findViewById(R.id.day_name_details);
        dayName.setText(weatherObj.getDay());

        TextView weatherConditionText = findViewById(R.id.weather1_text_details);
        weatherConditionText.setText(weatherObj.getCondition());

        TextView weatherConditionDetailsText = findViewById(R.id.weather2_text_details);
        weatherConditionDetailsText.setText(weatherObj.getDescription());

        TextView temperatureText = findViewById(R.id.temperature_text_details);
        temperatureText.setText(weatherObj.getMaxTemp() + " °C");

        TextView humidity = findViewById(R.id.humidity_details);
        humidity.setText(weatherObj.getHumidity() + " %");

        TextView pressure = findViewById(R.id.pressure_details);
        pressure.setText(weatherObj.getPressure() + " kPa");

        TextView windDeg = findViewById(R.id.wind_degree_details);
        windDeg.setText(weatherObj.getWindDeg() + " degrees");


    }
}