package com.avaj; //keep the run, source and scenario files out of the package

import com.avaj.weather.*;
import com.avaj.aircraft.*;
import java.io.*;

public class Simulator {
    private static WeatherTower wt;
    private static String line;
    private static int simCount;
    public static void main(String[] args) throws InterruptedException{
        try (BufferedReader buffIn  = new BufferedReader(new FileReader(args[0]))){
            if ((line = buffIn.readLine()) != null) {
                simCount = Integer.parseInt(line.split(" ")[0]); //try catch NFE
            }
            if (simCount <= 0){
                System.out.println("Invalid simulation count");
                System.exit(1);
            }
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

            for(int i = 0; i < simCount; i++){
                wt.changeWeather();
            }
            wt.dumpObservers();

/*             Coordinates myCoordinates = new Coordinates(1, 2, 3);
            String s1 = wt.getWeather(myCoordinates);
            System.out.println(s1); */

        } catch(IOException e) {    
            System.err.println("IOE / FNFE: " + e);
        } catch(IndexOutOfBoundsException e) { 
            System.err.println("IOOBE / AIOOBE: Please provide one argument " + e);
        } catch(NumberFormatException nfe) {
            System.err.println("NFE: First line should be an integer " + nfe);
        } catch(NullPointerException e){
            e.printStackTrace();
        }finally {
            System.out.println("Done, yay!");
        }
    }
}

//Will also catch FileNotFoundException
//FileReader() will throw an FNFE
//readline() will throw an IOE
//Will also catch ArrayIndexOutOfBoundsException
//integer.parseint() will throw number format exception