package com.avaj;

import com.avaj.weather.*;
import com.avaj.aircraft.*;
import java.io.*;
import java.util.*;

public class Simulator {
    private static WeatherTower wt;
    private static String line;
    private static int simCount;
    public static void main(String[] args) throws InterruptedException{
        try (BufferedReader buffIn  = new BufferedReader(new FileReader(args[0]))){
            if ((line = buffIn.readLine()) == null) 
                throw new FileFormatException("The scenario file could not be read.");
            if(!isNumber(line.split(" ")[0]))
                throw new FileFormatException("The simulation count has the wrong format.");
            simCount = Integer.parseInt(line.split(" ")[0]);
            if (simCount <= 0) 
                throw new FileFormatException("The simulation count is invalid.");
            wt = new WeatherTower();
            while((line = buffIn.readLine()) != null){
                Flyable ac = AircraftFactory.newAircraft(   
                    line.split(" ")[0],
                    line.split(" ")[1],
                    Integer.parseInt(line.split(" ")[2]),
                    Integer.parseInt(line.split(" ")[3]),
                    Integer.parseInt(line.split(" ")[4]));
                wt.register(ac);
                ac.registerTower(wt);
            }
            for(int i = 0; i < simCount; i++)
                wt.changeWeather();
        }catch(NumberFormatException e){
            System.err.println("NFE" + e.getMessage());
        }catch(FileFormatException e){    
            System.err.println(e.getMessage());
        }catch(Md5Exception e){
            System.err.print(e.getMessage());
        }catch(IOException e){    
            System.err.println("IOE" + e.getMessage());
        }catch(IndexOutOfBoundsException e){ 
            System.err.println("IOOB" + e.getMessage());
        }catch(NullPointerException e){
            System.err.println("NPE" + e.getMessage());
        }finally{
            System.out.println("Done, yay!");
        }
        //interrupted exception
    }
}

//Will also catch FileNotFoundException
//FileReader() will throw an FNFE
//readline() will throw an IOE
//Will also catch ArrayIndexOutOfBoundsException
//integer.parseint() will throw number format exception
//simCount = Integer.parseInt(line.split(" ")[0]); throws NumberFormatException
//keep the run, source and scenario files out of the package

            //wt.dumpObservers();
/*             Coordinates myCoordinates = new Coordinates(1, 2, 3);
            String s1 = wt.getWeather(myCoordinates);
            System.out.println(s1); */