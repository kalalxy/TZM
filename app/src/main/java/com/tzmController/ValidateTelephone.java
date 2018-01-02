package com.tzmController;

/**
 * Created by kal-al on 17-12-25.
 */

public class ValidateTelephone {
    private static final ValidateTelephone ourInstance = new ValidateTelephone();

    public static ValidateTelephone getInstance() {
        return ourInstance;
    }

    private ValidateTelephone() {}

    public boolean validateTelephone(int telephone){
        if(Integer.bitCount(telephone)==11){
//            TODO 莫磊
            return true;
        }
        return false;
    }
}
