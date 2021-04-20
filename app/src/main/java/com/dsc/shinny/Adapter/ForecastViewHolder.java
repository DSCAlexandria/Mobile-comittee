package com.dsc.shinny.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dsc.shinny.DetailsActivity;
import com.dsc.shinny.R;
import com.dsc.shinny.Weather;

public class ForecastViewHolder extends RecyclerView.ViewHolder {
    private final Context itemContext;

    ImageView iconImage;
    TextView weatherConditionText;
    TextView weatherDescriptionText;
    TextView temperatureText;
    TextView dayNameText;
    Weather clickedForecast;

    public ForecastViewHolder(@NonNull View itemView) {
        super(itemView);
        itemContext = itemView.getContext();

        iconImage = itemView.findViewById(R.id.icon);
        weatherConditionText = itemView.findViewById(R.id.weather_condition);
        weatherDescriptionText = itemView.findViewById(R.id.weather_description);
        temperatureText = itemView.findViewById(R.id.temperature_text);
        dayNameText = itemView.findViewById(R.id.day_name_details);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent intent = new Intent(itemContext, DetailsActivity.class);
                /*
                // method 1
                intent.putExtra("iconDrawableID", clickedForecast.getIconResId());
                intent.putExtra("weatherCondition", clickedForecast.getCondition());
                intent.putExtra("weatherConditionDetails", clickedForecast.getDescription());
                intent.putExtra("temperature", clickedForecast.getMaxTemp());
                intent.putExtra("dayName",clickedForecast.getDay());
                intent.putExtra("humidity",clickedForecast.getHumidity());
                intent.putExtra("pressure",clickedForecast.getPressure());
                intent.putExtra("windDeg",clickedForecast.getWindDeg());
                // End method 1
                */

                //method 2
                Bundle bundle = new Bundle();
                bundle.putSerializable(DetailsActivity.BUNDLE_KEY /* key */, clickedForecast);
                intent.putExtras(bundle);
                //End method 2

                itemContext.startActivity(intent);
            }
        });
    }

    public void bind(Weather forecast) {
        clickedForecast = forecast;

        String temperature = forecast.getMaxTemp() + " / " + forecast.getMinTemp() + " °C";

        iconImage.setImageResource(forecast.getIconResId());
        weatherConditionText.setText(forecast.getCondition());
        weatherDescriptionText.setText(forecast.getDescription());
        temperatureText.setText(temperature);
        dayNameText.setText(forecast.getDay());

    }

}
