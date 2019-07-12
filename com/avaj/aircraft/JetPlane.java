package com.avaj.aircraft;

import com.avaj.weather.*;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    @Override
    public void updateConditions(){
        switch (this.weatherTower.getWeather(this.coordinates)){
            case "SUN":
                coordinateDeltas(10, 0, 2); //latitude, longitude, height
                logWeatherMessage("I'm a jet, its sunny.");
                break;
            case "RAIN":
                coordinateDeltas(5, 0, 0);
                logWeatherMessage("I'm a jet, its raining.");
                break;
            case "FOG":
                coordinateDeltas(1, 0, 0);
                logWeatherMessage("I'm a jet, its foggy.");
                break;
            case "SNOW":
                coordinateDeltas(0, 0, 7);
                logWeatherMessage("I'm a jet, its snowing.");
                break;
            default:
            logWeatherMessage("I'm a jet, ... weather tower unresponsive");
                break;
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() < 0){
            this.coordinates.setHeight(0);
            logWeatherMessage("landing.");
            this.weatherTower.unregister(this);
            this.weatherTower = null;
        }
    }
    @Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }
    @Override
    public void setType(){
        this.type = "JetPlane";
    }
}