package com.avaj.weather;

import com.avaj.aircraft.*;

public class WeatherTower extends Tower
{   
    public WeatherTower(){
    }
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather(){
        conditionsChanged();
    }
}
