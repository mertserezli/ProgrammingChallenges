package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println( CalculateAge.inSeconds("26/06/1997") );
        }catch (Exception e){
            System.out.println("Control input");
        }
    }
}
