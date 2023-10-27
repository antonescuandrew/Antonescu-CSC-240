package org.example;

public class Forecast {
    String dayOfWeek;
    int high, low, humidity, precipitation;

    public String getForecast(){
        return dayOfWeek + " - High: " + high + "F Low: " +
                low + "F Humidity: " + humidity + "% Precipitation: " + precipitation + "%";
    }
}
