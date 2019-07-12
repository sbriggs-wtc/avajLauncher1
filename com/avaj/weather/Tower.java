package com.avaj.weather;
import com.avaj.Logger;
import com.avaj.aircraft.*;

import java.util.ArrayList;
import java.util.List; //imports the List<> interface

public abstract class Tower{
    private List<Flyable> observers = new ArrayList<Flyable>();
    public void register(Flyable flyable){
        observers.add(flyable);
        Logger.getLogger().logMessage("Tower says ");
    }
    public void unregister(Flyable flyable){

    }
    protected void conditionsChanged(){
        for(int i = 0; i < observers.size(); i++){
            Flyable ac = observers.get(i);
            ac.updateConditions();
        }
    }
    //Vardump for testing
    public void dumpObservers(){
        for(int i = 0; i < observers.size(); i++){
            String type = observers.get(i).getType();
            String name = observers.get(i).getName();
            String id = Long.toString(observers.get(i).getId());
/*          
            String longitude;
            String latitude;
            String height;
*/
            System.out.println(type + " " + name + "(" + id + ")");
/*          
            System.out.print(observers.get(i).getType() + "#");
            System.out.println(observers.get(i).getName() + "(" + (i + 1) + ")");
*/
        }
    }
}