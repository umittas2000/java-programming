package chapter4;

import java.util.Random;
import java.util.Scanner;

public class RollTheDie {
    public static void main(String[] args) {
        //Roll The die game
        /**
         * There will be gameboard which has 20 spaces on it.
         * Player will play the game 4 times
         * player will roll the die 5 times in each game.
         * end of 5 roll, if total number is less
         * or greater than totalSpaces player will lose
         * if player gets to 20 before 5 rolls, end the game and
         * Message Player win.
         */

        //final variable can't be changed after declaration.
        final int totalSpaces = 20;
        final int totalDieroll=5;
        int totalGame = 4;
        int score = 0;
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the Roll The Die game!");
        System.out.print("Press Enter to start!");
        input.nextLine();

        //Outer for loop to run Total number of Game play.
        for(int i=1;i<=totalGame;i++){

            //inner loop to roll [n] number of die on each game play
            for(int j=0;j<totalDieroll;j++){
                //input is used just for  place holder
                //input.nextLine();

                //random class to generate random number
                int die = random.nextInt(6)+1;
                score += die;


                //inform status to player (j+1) is just for display purpose.
                System.out.println(i+". Game, " + (j+1)+ ". Roll, Die is: "+die + " , Score is:" +score);

                //Our decision maker here,
                //if player score is less or equal to totalSpace, continue
                if(score>=totalSpaces){
                    break;
                }

                //if decision is not true, continue to play:
                System.out.println(" Press Enter to roll");
                input.nextLine();
            }

            //Decision here if score is winning score celebrate and end the game.
            if(isWin(score,totalSpaces))  {
                System.out.println("Congratulations! You won!, Score : "+score);
                break;

            //if it's not winning score, continue to play
            }else{
                //If there is no win, play until the end of the game.
                if(i<totalGame && score<20) {
                    System.out.println("You lost!");
                    System.out.println("You have " + (totalGame - i) +" more game(s), press any key to play");

                    //Depends on the rules, you can clear Score on each iteration
                    score=0;

                    input.nextLine();
                }else{
                    System.out.println("You lost! Game over. Score : "+score);
                   //Depends on the rules, you can stop playing if score reaches over 20
                    score=0;
                    // break;
                }
            }
        }


    }

    public static boolean isWin(int value,int totalSpaces){
        if(value==totalSpaces){
            return true;
        }else{
            return false;
        }
    }

}
