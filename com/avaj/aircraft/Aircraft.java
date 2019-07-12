package com.avaj.aircraft;

import com.avaj.Logger;

public abstract class Aircraft{
    private static long idCounter = 1;
    protected long id;
    protected String name;
    protected String type;
    protected Coordinates coordinates;
    protected String messagePrefix;
    protected Aircraft(String name, Coordinates coordinates){
        setName(name);
        setCoordinates(coordinates);
        setId(nextId());
        setType();
        setMessagePrefix(getType()+"#"+getName()+"("+getId()+")");
    }
    private long nextId(){
        return(idCounter++);
    }
    public void setId(long nextId){
        this.id = nextId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public String getName(){
        return(this.name);
    }
    public Coordinates getCoordinates(){
        return(this.coordinates);
    }
    public void coordinateDeltas(int x, int y, int z){
        if (x != 0)
            this.coordinates.setLatitude(this.coordinates.getLatitude() + x);
        if (y != 0)
            this.coordinates.setLongitude(this.coordinates.getLongitude() + y);
        if (z != 0)
            this.coordinates.setHeight(this.coordinates.getHeight() + z);
    }
    public void logCoordinates(Coordinates coordinates){
        Logger./* getLogger(). */logMessage("Coordinates: "+
            Integer.toString(this.coordinates.getLongitude())+" "+
            Integer.toString(this.coordinates.getLatitude())+" "+
            Integer.toString(this.coordinates.getHeight())); 
    }
    public String getMessagePrefix(){
        return this.messagePrefix;
    }
    public String getType(){
        return this.type;
    }
    public void setType(){
    }
    public void logWeatherMessage(String message){
        Logger./* getLogger(). */logMessage(getMessagePrefix()+": "+message);
    }
    public long getId(){
        return this.id;
    }
    public void setMessagePrefix(String messagePrefix){
        this.messagePrefix = messagePrefix;
    }
}