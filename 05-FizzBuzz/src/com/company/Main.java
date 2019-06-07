package com.company;

public class Main {

    public static void main(String[] args) {
        fizzBuzz();
    }

    public static void fizzBuzz(){
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            if( i%3 == 0 ){
                sb.append("Fizz");
            }
            if ( i%5 ==0 ){
                sb.append("Buzz");
            }
            System.out.println(i + " " +sb.toString());
        }
    }
}

