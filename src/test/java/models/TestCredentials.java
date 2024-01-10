package models;

import org.apache.commons.codec.binary.Base64;

public class TestCredentials {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "Engineer_123";

    public static String getCredentials(){
        return new String(Base64.encodeBase64((USERNAME + ":" + PASSWORD).getBytes()));
    }
}