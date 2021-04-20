package com.dsc.shinny;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Weather implements Serializable {
    private String day;
    private String condition;
    private String description;
    private int humidity;
    private int pressure;
    private int iconResId = 0;

    @SerializedName("min_temp")
    private int minTemp;
    @SerializedName("max_temp")
    private int maxTemp;
    @SerializedName("wind_deg")
    private int windDeg;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }


    public int getIconResId() {
        if (iconResId == 0) iconResId = IconUtils.getIconResId(getCondition());
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "day='" + day + '\'' +
                ", condition='" + condition + '\'' +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", windDeg=" + windDeg +
                '}';
    }

}
