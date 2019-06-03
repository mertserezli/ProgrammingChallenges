package com.company;

import java.util.Random;

public class UsernameGenerator {

    private static char[] CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._".toCharArray();

    public static String generateName(int minLength, int maxLength){
        Random r = new Random();
        int length = minLength + r.nextInt(maxLength - minLength);
        StringBuilder sb = new StringBuilder();
        r.ints(length, 0, CHARSET.length).forEach(i -> sb.append(CHARSET[i]));
        return sb.toString();
    }

}
