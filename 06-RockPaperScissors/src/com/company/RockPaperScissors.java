package com.company;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public enum Hand{Rock, Paper, Scissors}

    private static Hand intToHand(int i){
        switch (i){
            case 0: return Hand.Rock;
            case 1: return Hand.Paper;
            case 2: return Hand.Scissors;
            default: return null;
        }
    }

    private static Hand generateRandomHand(){
        return intToHand( new Random().nextInt(3) );
    }

    private static Hand getUserMove(){
        Scanner s = new Scanner(System.in);
        Hand userHand;
        do {
            System.out.println("Enter 0 for rock, 1 for paper and 2 for scissors");
            int input = s.nextInt();
            userHand = intToHand(input);
        }while (  userHand == null );
        return userHand;
    }

    public static void play(){
        Hand compHand = generateRandomHand();
        Hand userHand = getUserMove();
        if(compHand == userHand) System.out.println("Draw!");
        else if(compHand == Hand.Paper){
            if (userHand == Hand.Rock) System.out.println("Computer wins!");
            else System.out.println("You win!");
        }
        else if (compHand == Hand.Rock ) {
            if (userHand == Hand.Paper) System.out.println("You win!");
            else System.out.println("Computer wins!");
        }
        else{//Computer has Scissors
            if(userHand == Hand.Rock) System.out.println("You win!");
            else System.out.println("Computer wins!");
        }
    }
}
