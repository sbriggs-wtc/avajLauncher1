package com.avaj.aircraft;

import com.avaj.weather.WeatherTower;

public interface Flyable{
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public String getName(); //needed for vardump test
    public String getType(); //needed for vardump test
    //public Coordinates getCoordinates();
    public long getId(); //needed for vardump test
    //public void logWeatherMessage(String message);
    public String getMessagePrefix(); //needed for tower message
}