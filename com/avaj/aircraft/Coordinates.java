package com.avaj.aircraft;

public class Coordinates{
    private int latitude;
    private int longitude;
    private int height;
    
    Coordinates(int latitude, int longitude, int height){
        setLatitude(latitude);
        setLongitude(longitude);
        setHeight(height);
    }
    public void setLatitude(int latitude){
        this.latitude = latitude;
    }
    public void setLongitude(int longitude){
        this.longitude = longitude;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getLatitude(){
        return (this.latitude);
    }
    public int getLongitude(){
        return (this.longitude);
    }
    public int getHeight(){
        return (this.height);
    }
}