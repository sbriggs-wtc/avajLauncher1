package com.avaj.aircraft;

import com.avaj.Logger;
import com.avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    @Override
    public void updateConditions(){
        switch (this.weatherTower.getWeather(this.coordinates)){
            case "SUN":
                coordinateDeltas(5, 10, 0); //latitude, longitude, height
                logWeatherMessage("Its sunny yay!");
                break;
            case "RAIN":
                coordinateDeltas(0, 5, 0);
                logWeatherMessage("Its raining yay!");
                break;
            case "FOG":
                coordinateDeltas(0, 1, 0);
                logWeatherMessage("Its foggy yay!");
                break;
            case "SNOW":
                coordinateDeltas(5, 10, 0);
                logWeatherMessage("Its snowing yay!");
                break;
            default:
            logWeatherMessage("Weather tower unresponsive yay!");
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
    public String getType(){
        return "Helicopter";
    }
    public long getId(){
        return this.id;
    }
    public void coordinateDeltas(int x, int y, int z){
        this.coordinates.setLatitude(this.coordinates.getLatitude() + x);
        this.coordinates.setLongitude(this.coordinates.getLongitude() + y);
        this.coordinates.setHeight(this.coordinates.getHeight() + z);
    }
    public void logCoordinates(Coordinates coordinates){
        Logger.getLogger().logMessage("Coordinates: "+
                    Integer.toString(this.coordinates.getLongitude())+" "+
                    Integer.toString(this.coordinates.getLatitude())+" "+
                    Integer.toString(this.coordinates.getHeight())); 
    }
    public void logWeatherMessage(String message){
        String type = getType();
        String name = getName();
        String id = Long.toString(getId());
        Logger.getLogger().logMessage(type+" "+name+"("+id+"): "+message);
    }
}