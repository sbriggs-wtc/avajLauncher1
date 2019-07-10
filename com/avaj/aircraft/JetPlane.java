package com.avaj.aircraft;

import com.avaj.weather.*;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        switch (this.weatherTower.getWeather(this.coordinates)){
            case "SUN":
            case "RAIN":
            case "FOG":
            case "SNOW":
            default:
                System.out.println("Weather Tower unresponsive");
            break;
        }
    }
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }
    public String getType(){
        return("JetPlane");
    }
}