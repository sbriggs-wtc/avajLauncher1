package com.avaj.aircraft;



public abstract class Aircraft{
    private static long idCounter;
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Aircraft(String name, Coordinates coordinates){
        setName(name);
        setCoordinates(coordinates);
    }
    private long nextId(){
        return(0);
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
}