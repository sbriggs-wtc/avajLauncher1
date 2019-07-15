package com.avaj;

import com.avaj.weather.*;
import com.avaj.aircraft.*;
import java.io.*;

public class Simulator {
    private static String line;
    private static int simCount;
    public static void main(String[] args) throws InterruptedException{
        try (BufferedReader buffIn  = new BufferedReader(new FileReader(args[0]))){
            if((line = buffIn.readLine()) == null) 
                throw new FileFormatException("The scenario file could not be read.");
            if(!isNumber(line.split(" ")[0]))
                throw new FileFormatException("The scenario file is in the wrong format.");
            if((simCount = Integer.parseInt(line.split(" ")[0])) <= 0)
                throw new FileFormatException("The simulation count is invalid.");
            WeatherTower weatherTower = new WeatherTower();
            while((line = buffIn.readLine()) != null){
                Flyable flyable = AircraftFactory.newAircraft(   
                    line.split(" ")[0],
                    line.split(" ")[1],
                    Integer.parseInt(line.split(" ")[2]),
                    Integer.parseInt(line.split(" ")[3]),
                    Integer.parseInt(line.split(" ")[4]));
                weatherTower.register(flyable);
                flyable.registerTower(weatherTower);
            }
            for(int i = 0; i < simCount; i++)
                weatherTower.changeWeather();
        }catch(NumberFormatException e){
            System.err.println("NFE" + e.getMessage());
        }catch(FileFormatException e){    
            System.err.println("FFE" + e.getMessage());
        }catch(Md5Exception e){
            System.err.print("MD5E" + e.getMessage());
        }catch(IOException e){    
            System.err.println("IOE" + e.getMessage());
        }catch(IndexOutOfBoundsException e){ 
            System.err.println("IOOB" + e.getMessage());
        }catch(NullPointerException e){
            System.err.println("NPE" + e.getMessage());
        }finally{
            System.out.println("Done, yay!");
        }
    }
    public static boolean isNumber(String string){
        for (int i = 0; i < string.length(); i++){
            if(!Character.isDigit(string.charAt(i)))
                return false;
        }
        return true;
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