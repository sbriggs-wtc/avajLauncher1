package com.avaj;


public final class Md5Parser{
    private static Md5Parser md5Parser = null;
    private Md5Parser(){}
    public static Md5Parser getMd5Parser(){
        if (md5Parser == null)
            md5Parser = new Md5Parser();
        return md5Parser;
    }
    public boolean isMd5Format(){
        return true;
    }
    public String reverseHashAircraftType(String type){
        return "Hello";
    }
}