package com.dsc.shinny.Adapter;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dsc.shinny.R;
import com.dsc.shinny.Weather;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
    private final int TYPE_HEADER = 0;
    private final int TYPE_CELL = 1;
    private ArrayList<Weather> weatherList;

    public ForecastAdapter(ArrayList<Weather> weatherList) {
        this.weatherList = weatherList;
    }


    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int cellId;
        if (viewType == TYPE_HEADER)
            cellId = R.layout.forecast_header;
        else
            cellId = R.layout.forecast_cell;

        View view = LayoutInflater.from(parent.getContext()).inflate(cellId, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        holder.bind(weatherList.get(position));

    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        else
            return TYPE_CELL;
    }

}
