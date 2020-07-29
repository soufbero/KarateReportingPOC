package com.souf.karate;

import java.net.URL;

public class TestingUtil {

    public static boolean validateURL(boolean shouldValidate, String alwaysPassing, String url){
        if (!shouldValidate){
            return true;
        }
        if (alwaysPassing.equals(url)){
            return true;
        }
        try{
            new URL(url);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
