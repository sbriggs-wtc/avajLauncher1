package com.avaj;


public final class Md5Parser{
    private static Md5Parser md5Parser = null;
    private Md5Parser(){}
    public static Md5Parser getMd5Parser(){
        if (md5Parser == null)
            md5Parser = new Md5Parser();
        return md5Parser;
    }
    public boolean isMd5Format(String string){
        if(string.length() == 32){
            for(int i = 0; i < 32; i++){
                if(!Character.isLetterOrDigit(string.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }
    public String reverseHashAircraftType(String type) throws Md5Exception{
        type.toLowerCase();
        switch (type) {
            case "2ab8b43468e8b92b0fc5c81e70e35a2d":
                return "Helicopter";
            case "554cd647d6b135f7e36ab1214c5e816a":
                return "JetPlane";
            case "994736b4f0aec72f6e5ae580051d012f":
                return "Baloon";
            default:
                throw new Md5Exception("MD5 string could not be decrypted.");
        }
    }
}