package com.avaj;

import java.io.*;

public final class Logger{
    private static Logger logger = null;
    Logger(){}
    public static Logger getLogger(){
        if (logger == null)
            logger = new Logger();
        return logger;
    }
    public static void logMessage(String message){

        System.out.println(message);
        try{
            BufferedWriter buffOut = new BufferedWriter(new FileWriter("simulation.txt"));
            buffOut.write(message);
            buffOut.write('\n');
            buffOut.close();
        } catch (IOException e) {
               System.out.println("ioe in logger" + e);
        }
    }
}