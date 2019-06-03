package com.company;

import java.util.Random;
import java.util.Scanner;

public class HeadsTails {

    enum CoinState {Heads, Tails}

    public static CoinState flipCoin(){
        return new Random().nextBoolean() ? CoinState.Heads: CoinState.Tails;
    }

    public static void play()
    {
        System.out.println("Heads or Tails?");
        int guess;
        do {
            System.out.println("Enter 1 for Heads or 0 for Tails");
            guess = new Scanner(System.in).nextInt();
        }while(guess != 1 && guess != 0 );
        CoinState guessState = guess == 1 ? CoinState.Heads: CoinState.Tails;
        if (flipCoin() == guessState){
            System.out.println("You win");
        }else {
            System.out.println("You lose");
        }
    }
}
