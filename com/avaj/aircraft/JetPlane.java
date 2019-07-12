package com.avaj.aircraft;

import com.avaj.weather.*;
import com.avaj.Logger;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
        setType("JetPlane");
        setMessagePrefix(getType()+" "+getName()+"("+getId()+"): ");
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
            //deregister aircraft from tower
            //deregister tower from aircraft
            //log landed message
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }
    public long getId(){
        return this.id;
    }
    public void logWeatherMessage(String message){
        Logger.getLogger().logMessage(messagePrefix + message);
    }
    public void setMessagePrefix(String messagePrefix){
        this.messagePrefix = messagePrefix;
    }
}