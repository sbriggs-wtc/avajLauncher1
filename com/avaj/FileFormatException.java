package com.avaj;

public class FileFormatException extends Exception{
    FileFormatException(){}
    FileFormatException(String message){
        super(message); 
    }
    //Implementations of java.io.Serializable require the serialVersionUID to be set    
    private static final long serialVersionUID = 999; 
}