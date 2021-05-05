package com.dsc.shinny.Adapter;

import android.content.Context;
import android.content.Intent;
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
    Weather weatherObj;

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
                Intent intent = new Intent(itemContext, DetailsActivity.class);
                intent.putExtra(DetailsActivity.KEY, weatherObj);

                itemContext.startActivity(intent);
            }
        });
    }

    public void bind(Weather forecast) {
        weatherObj = forecast;

        String temperature = forecast.getMaxTemp() + " / " + forecast.getMinTemp() + " °C";

        iconImage.setImageResource(forecast.getIconResId());
        weatherConditionText.setText(forecast.getCondition());
        weatherDescriptionText.setText(forecast.getDescription());
        temperatureText.setText(temperature);
        dayNameText.setText(forecast.getDay());

    }

}
