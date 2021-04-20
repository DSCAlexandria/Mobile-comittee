package com.dsc.shinny;

public class IconUtils {

    public static int getIconResId(String condition) {
        condition = condition.toLowerCase();

        switch (condition) {
            case "clear":
                return R.drawable.ic_clear;
            case "cloudy":
                return R.drawable.ic_cloudy;
            case "rainy":
                return R.drawable.ic_rainy;
            case "foggy":
                return R.drawable.ic_foggy;
            default:
                return R.drawable.ic_error;
        }

    }


}
