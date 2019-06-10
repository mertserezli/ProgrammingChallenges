package com.company;

import java.util.HashSet;
import java.util.Set;

public class LoveCalculator {

    private static int digitCharToInt(char digitChar){
        return digitChar - '0';
    }

    private static int countOccurrencesOfSingleCharInString(String s, char c){
        int count = 0;
        for(char i: s.toCharArray()){
            if(i == c) count++;
        }
        return count;
    }

    private static String countOccurrencesOfAllCharsInString(String s){
        StringBuilder countsConcat = new StringBuilder();
        Set<Character> characters = new HashSet<>();
        s.chars().forEach(i -> characters.add((char)i));
        for(char c: characters) {
            countsConcat.append( countOccurrencesOfSingleCharInString(s, c) );
        }
        return countsConcat.toString();
    }

    //calculated according to https://www.youtube.com/watch?v=oFsLVG7EAZ4
    public static int calculate(String name1, String name2){
        String percent = countOccurrencesOfAllCharsInString(name1 + "loves" + name2);
        while(2 < percent.length()) {
            int leftIndex = 0;
            int rightIndex = percent.length() - 1;
            StringBuilder newPercent = new StringBuilder();
            while(leftIndex - rightIndex != 1 && leftIndex != rightIndex) {
                newPercent.append( digitCharToInt(percent.charAt(leftIndex)) + digitCharToInt(percent.charAt(rightIndex)) );
                leftIndex++;
                rightIndex--;
                if(leftIndex == rightIndex) newPercent.append( digitCharToInt(percent.charAt(leftIndex)) );
            }
            percent = newPercent.toString();
        }
        return Integer.parseInt(percent);
    }
}
