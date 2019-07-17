package com.avaj;

import java.io.*;
import java.util.ArrayList;

public class Logger {
    public static ArrayList<String> messages = new ArrayList<>();
    private static Logger logger = null;
    Logger(){}
    public static Logger getLogger(){
        if (logger == null)
            logger = new Logger();
        return logger;
    }
    public void logMessage(String message){
        messages.add(message);
    }
    public void logMessagesToFile(){
        BufferedWriter buffOut;
        try{
            buffOut = new BufferedWriter(new FileWriter("simulation.txt"));
            for(String s : messages){
                buffOut.write(s + '\n');
                buffOut.flush();
            }
            buffOut.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
