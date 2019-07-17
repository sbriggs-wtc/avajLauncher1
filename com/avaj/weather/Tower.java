package com.avaj.weather;
import com.avaj.Logger;
import com.avaj.aircraft.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower{
    private List<Flyable> observers = new ArrayList<Flyable>();
    public void register(Flyable flyable){
        observers.add(flyable);
        Logger.getLogger().logMessage("Tower says: "+flyable.getMessagePrefix()+" registered to weather tower.");
    }
    public void unregister(Flyable flyable){
        observers.remove(flyable);
        Logger.getLogger().logMessage("Tower says: "+flyable.getMessagePrefix()+" unregistered from weather tower.");
    }
    protected void conditionsChanged(){
        for(int i = 0; i < observers.size(); i++){
            Flyable ac = observers.get(i);
            ac.updateConditions();
        }
    }
}