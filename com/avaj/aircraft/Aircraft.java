package com.avaj.aircraft;

public abstract class Aircraft{
    private static long idCounter = 1;
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Aircraft(String name, Coordinates coordinates){
        setName(name);
        setCoordinates(coordinates);
        setId(nextId());
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
}