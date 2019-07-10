package com.avaj.weather;
import com.avaj.aircraft.*;

import java.util.ArrayList;
import java.util.List; //imports the List<> interface

public abstract class Tower{
    private List<Flyable> observers = new ArrayList<Flyable>();
    public void register(Flyable flyable){
        observers.add(flyable);
    }
    public void unregister(Flyable flyable){

    }
    protected void conditionsChanged(){
        //update all aircraft coordinates and display their unique messages
    }
    //Vardump for testing
    public void dumpObservers(){
        for(int i = 0; i < observers.size(); i++){
            System.out.print(observers.get(i).getType() + "#");
            System.out.println(observers.get(i).getName() + "(" + (i + 1) + ")");
        }
    }
}