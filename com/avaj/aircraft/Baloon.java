package com.avaj.aircraft;

public class Baloon extends Aircraft implements Flyable{
    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        
    }
    public void registerTower(){

    }
    public String getType(){
        return("Baloon");
    }
}