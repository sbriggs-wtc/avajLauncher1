package com.avaj.aircraft;

import com.avaj.weather.*;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    @Override
    public void updateConditions(){
        switch (this.weatherTower.getWeather(this.coordinates)){
            case "SUN":
                coordinateDeltas(0, 2, 4); //latitude, longitude, height
                logWeatherMessage("I'm a baloon, its sunny.");
                break;
            case "RAIN":
                coordinateDeltas(0, 0, 5);
                logWeatherMessage("I'm a baloon, its raining.");
                break;
            case "FOG":
                coordinateDeltas(0, 0, 3);
                logWeatherMessage("I'm a baloon, its foggy.");
                break;
            case "SNOW":
                coordinateDeltas(0, 0, 15);
                logWeatherMessage("I'm a baloon, its snowing.");
                break;
            default:
            logWeatherMessage("I'm a baloon, ... weather tower unresponsive");
                break;
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() < 0){
            this.coordinates.setHeight(0);
            //deregister aircraft from tower
            //deregister tower from aircraft
            //log landed message
        }
    }
    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }
    public void setType(){
        this.type = "Baloon";
    }
}