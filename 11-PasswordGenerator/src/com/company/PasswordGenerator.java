package com.company;

import java.util.Random;

public class PasswordGenerator {
    private static char[] CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghıjklmnopqrstuvwxyz0123456789~!@#$%^&*()_+".toCharArray();

    public static String generatePassword(int maxLength){
        Random r = new Random();
        int minLength = 6;
        int length = minLength + r.nextInt(maxLength - minLength);
        StringBuilder sb = new StringBuilder();
        r.ints(length, 0, CHARSET.length).forEach(i -> sb.append(CHARSET[i]));
        return sb.toString();
    }
}
