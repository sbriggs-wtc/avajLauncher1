package com.avaj.weather;
import com.avaj.aircraft.*;

import java.util.ArrayList;
import java.util.List; //imports the List<> interface

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();
    public void register(Flyable flyable)
    {
        
    }
    public void unregister(Flyable flyable)
    {

    }
    protected void conditionsChanged()
    {

    }
}