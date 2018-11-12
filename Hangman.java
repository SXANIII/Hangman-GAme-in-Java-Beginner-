import java.util.Scanner;
import java.util.*;
public class Hangman {


    public static void main(String[] args) {

        int Attempts = 8;
        String targetWord;
        char guessed;
        char[] blanks;
        boolean gameIsTrue = true;
        ArrayList<String> tried = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        String playerOneWord = "Player One, enter a word:";

        String playerTwoWin = "Game over. Player Two wins!";


        System.out.println(playerOneWord);
        targetWord = input.next();

        int length = targetWord.length();

        blanks = new char[length];

        for(int i = 0; i < length; i++){
            blanks[i] = '_';
        }

        for (char blank: blanks) {
            System.out.print(blank);
        }
        System.out.println();

        while(gameIsTrue){

            System.out.println("Player Two, you have " + Attempts + " guesses left. Enter a guess:");

            String theGuess = input.next();
            guessed = theGuess.charAt(0);

            if(tried.contains(theGuess)){
                System.out.println("You have already guessed '" + guessed + "'.");
            } else if(targetWord.indexOf(guessed) != -1 ) {
                for(int i = 0; i < length; i++){
                    if(targetWord.charAt(i) == guessed){
                        blanks[i] = guessed;
                    }
                }
            }
            else{
                Attempts--;
            }

            tried.add(theGuess);


            if(Attempts <= 0){
                System.out.println("Game over. Player One wins! The word was: " + targetWord);
                break;
            }

            for (char blank: blanks) {
                System.out.print(blank);
            }
            System.out.println();

            if(Arrays.toString(blanks).indexOf('_') == -1){
                System.out.println(playerTwoWin);
                break;
            }
        }

        input.close();

    }

}


