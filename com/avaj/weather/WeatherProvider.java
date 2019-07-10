package com.avaj.weather;

import com.avaj.aircraft.*;
//import java.io.*;
import java.util.Random;

public class WeatherProvider{
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private WeatherProvider(){}
    public static WeatherProvider getProvider(){
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return(weatherProvider);
    }
    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random();
        int randInt = rand.nextInt(4);
        return(weather[randInt]);
    }
}
