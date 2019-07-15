package com.avaj.aircraft;

//import com.avaj.Logger;
import com.avaj.Md5Exception;
import com.avaj.Md5Parser;

public abstract class AircraftFactory{
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Md5Exception{
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if(Md5Parser.getMd5Parser().isMd5Format(type)){
            try{
                type = Md5Parser.getMd5Parser().reverseHashAircraftType(type);
            }catch(Md5Exception md5e){
                throw md5e;
                //Logger.getLogger().logMessage(md5e.getMessage());
            }
        }
        switch(type){
            case "Helicopter":
                return (new Helicopter(name, coordinates));
            case "JetPlane":
                return (new JetPlane(name, coordinates));
            case "Baloon":
                return (new Baloon(name, coordinates));
            default:
                return null;
        }
    }
}

