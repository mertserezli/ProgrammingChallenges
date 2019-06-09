package com.company;

import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private int numOfTries = 8;
    private String word;
    private char[] guessedWord;

    private void selectWord(){
        try {
            RandomAccessFile raf = new RandomAccessFile("./wordlist.txt", "r");
            int fileLen = (int)raf.length();
            int pos = new Random().nextInt(fileLen);
            raf.seek(pos);
            word = raf.readLine();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void modifyGuessWord(char guess){
        for (int index = word.indexOf(guess);
             index >= 0;
             index = word.indexOf(guess, index + 1))
        {
            guessedWord[index] = guess;
        }
    }

    public void play(){
        System.out.println("Selecting random word:");
        //select random word.
        selectWord();
        guessedWord = new char[word.length()];
        for(int i = 0; i < guessedWord.length; i++){
            guessedWord[i] = '_';
        }
        System.out.println(word);
        //ask user a letter
        while( !word.equals(new String(guessedWord)) && 0 < numOfTries){
            System.out.println("current statte of your guesses is " + new String(guessedWord));
            Scanner keyboard = new Scanner(System.in);
            System.out.println("To guess the word enter 1, to guess a character enter 2");
            int choice = keyboard.nextInt();
            Scanner keyboard2 = new Scanner(System.in);
            if(choice == 1) {
                System.out.println("Enter a character");
                String input = keyboard2.nextLine();
                if (input.length() != 1) continue;
                if (word.contains(input)) {
                    modifyGuessWord(input.charAt(0));
                    System.out.println("Your guess character is in the word! Your current word is: " + new String(guessedWord));
                } else {
                    numOfTries--;
                    System.out.println("That letter is not in the word, you have " + numOfTries + " tries left");
                    System.out.println("Your current word is: " + new String(guessedWord));
                }
            }else{
                System.out.println("Enter a word");
                String input = keyboard2.nextLine();
                if(word.equals(input)){
                    System.out.println("You guessed it right.");
                    break;
                }else {
                    numOfTries--;
                    System.out.println("Sorry you couldn't guess it right, you have " + numOfTries + " tries left");
                    System.out.println("Your current word is: " + new String(guessedWord));
                }
            }
        }
        if(numOfTries !=0 ){
            System.out.println("you win! word: " + word);
        }else {
            System.out.println("you lose! word: " + word);
        }
    }
}
