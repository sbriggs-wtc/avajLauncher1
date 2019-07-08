package com.avaj; //keep the run, source and scenario files out of the package

import com.avaj.weather.*;
import com.avaj.aircraft.*;
import java.io.*;

public class Simulator {
    private static WeatherTower weatherTower;
    private static String line;
    private static int simCount;
    public static void main(String[] args) throws InterruptedException {
        try (   BufferedReader buffIn  = new BufferedReader(new FileReader(args[0]))) {
            if ((line = buffIn.readLine()) != null) {
                simCount = Integer.parseInt(line.split(" ")[0]);
                System.out.println(simCount);
            }
            if (simCount <= 0) {
                System.out.println("Invalid simulation count");
                System.exit(1);
            }
            weatherTower = new WeatherTower();
            aircraftFactory = new AircraftFactory();
            while((line = buffIn.readLine()) != null) {
                create ac;
                register ac;
                
                System.out.println((line.split(" ")[0]));
                System.out.println((line.split(" ")[1]));
                System.out.println((line.split(" ")[2]));
                System.out.println((line.split(" ")[3]));
            }
        } catch(IOException e) {    
            System.err.println("IOE / FNFE: " + e);
        } catch(IndexOutOfBoundsException e) { 
            System.err.println("IOOBE / AIOOBE: Please provide one argument " + e);
        } catch(NumberFormatException nfe) {
            System.err.println("NFE: First line should be an integer " + nfe);
        } finally {
            System.out.println("Done, yay!");
        }
    }
}

//Will also catch FileNotFoundException
//FileReader() will throw an FNFE
//readline() will throw an IOE
//Will also catch ArrayIndexOutOfBoundsException
//integer.parseint() will throw number format exception