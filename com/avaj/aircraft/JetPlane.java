package com.avaj.aircraft;

public class JetPlane extends Aircraft implements Flyable{
    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        
    }
    public void registerTower(){

    }
    public String getType(){
        return("JetPlane");
    }
}