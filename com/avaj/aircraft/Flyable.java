package com.avaj.aircraft;

import com.avaj.weather.WeatherTower;

public interface Flyable{
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public String getMessagePrefix(); //Needed for tower message
}
