package com.avaj.aircraft;

import com.avaj.Logger;
import com.avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
        setType("Helicopter");
        setMessagePrefix(getType()+" "+getName()+"("+getId()+"): ");
    }
    @Override
    public void updateConditions(){
        switch (this.weatherTower.getWeather(this.coordinates)){
            case "SUN":
                logCoordinates(this.coordinates);
                coordinateDeltas(5, 10, 0); //latitude, longitude, height
                logCoordinates(this.coordinates);
                logWeatherMessage("I'm a helicopter, its sunny.");
                break;
            case "RAIN":
                coordinateDeltas(0, 5, 0);
                logWeatherMessage("I'm a helicopter, its raining.");
                break;
            case "FOG":
                coordinateDeltas(0, 1, 0);
                logWeatherMessage("I'm a helicopter, its foggy.");
                break;
            case "SNOW":
                coordinateDeltas(5, 10, 0);
                logWeatherMessage("I'm a helicopter, its snowing.");
                break;
            default:
            logWeatherMessage("I'm a helicopter, ... weather tower unresponsive");
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