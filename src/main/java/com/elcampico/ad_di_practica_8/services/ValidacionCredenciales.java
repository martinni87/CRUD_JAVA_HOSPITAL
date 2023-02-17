package com.elcampico.ad_di_practica_8.services;

public class ValidacionCredenciales {
    private static final String LOGIN_UNAME = "root";
    private static final String LOGIN_PASSWD = "root";
    
    public static boolean checkCredenciales(String username, String password){
        if ("".equals(username) || "".equals(password)){
            return false;
        }
        if (!LOGIN_UNAME.equals(username)){
            return false;
        }
        if (!LOGIN_PASSWD.equals(password)) {
            return false;
        }
        return true;
    }
}
