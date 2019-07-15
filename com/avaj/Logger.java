package com.avaj;

import java.io.*;

public final class Logger{ //Final classes cannot be extended
    private static Logger logger = null;
    private static BufferedWriter buffOut = null;
    Logger(){}
    public static Logger getLogger(){
        if (logger == null)
            logger = new Logger();
        return logger;
    }
    public static void setWriter() throws IOException{
        buffOut = new BufferedWriter(new FileWriter("simulation.txt"));
    }
    public static BufferedWriter getWriter(){
        return(buffOut);
    }
    public void logMessage(String message){
/*         try{
            if (buffOut == null)
                setWriter();
            buffOut.write(message);
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("IOE thrown in logMessage");
        } */
        System.out.println(message);

    }
}