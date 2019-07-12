package com.avaj;

//import java.io.*;

public final class Logger{
    //private String outputFile;
    //private FileWriter fileWriter;
    //private PrintWriter printWriter;
    private static Logger logger = null;
    Logger(){}
    public static Logger getLogger(){
        if (logger == null)
            logger = new Logger();
        return logger;
    }
/*     public void setOutputFile(String outputFile){
        this.outputFile = outputFile;
    } */
    public void logMessage(String message){

        System.out.println(message);
    /*  try{
            this.printWriter = new PrintWriter(new FileWriter(outputFile));
            printWriter.println(message);

        } catch (IOException e) {
               System.out.println("ioe in logger" + e);
        } finally {
            printWriter.close();
        } */
    }
}