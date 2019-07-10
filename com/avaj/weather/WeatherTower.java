package com.avaj.weather;

import com.avaj.aircraft.*;

public class WeatherTower extends Tower
{   
    public WeatherTower(){
        System.out.println("WeatherTowerConstructor");
    }
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather(){
        conditionsChanged();
    }
}
