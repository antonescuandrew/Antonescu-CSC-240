package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Forecast> forecast = new ArrayList<>();

        Forecast monday = new Forecast();
        monday.dayOfWeek = "Monday";
        monday.high = 42;
        monday.low = 14;
        monday.humidity = 22;
        monday.precipitation = 32;
        forecast.add(monday);

        Forecast tuesday = new Forecast();
        tuesday.dayOfWeek = "Tuesday";
        tuesday.high = 49;
        tuesday.low = 38;
        tuesday.humidity = 14;
        tuesday.precipitation = 12;
        forecast.add(tuesday);

        Forecast wednesday = new Forecast();
        wednesday.dayOfWeek = "Wednesday";
        wednesday.high = 44;
        wednesday.low = 32;
        wednesday.humidity = 28;
        wednesday.precipitation = 0;
        forecast.add(wednesday);

        Forecast thursday = new Forecast();
        thursday.dayOfWeek = "Thursday";
        thursday.high = 38;
        thursday.low = 25;
        thursday.humidity = 32;
        thursday.precipitation = 0;
        forecast.add(thursday);

        Forecast friday = new Forecast();
        friday.dayOfWeek = "Friday";
        friday.high = 22;
        friday.low = 12;
        friday.humidity = 22;
        friday.precipitation = 80;
        forecast.add(friday);

        for (Forecast someDay : forecast){
            System.out.println(someDay.getForecast());
        }
    }
}