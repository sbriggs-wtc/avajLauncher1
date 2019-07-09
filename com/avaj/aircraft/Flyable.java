package com.avaj.aircraft;

public interface Flyable{
    public void updateConditions();
    public void registerTower();
    public String getName();
    public String getType();
    public Coordinates getCoordinates();
}