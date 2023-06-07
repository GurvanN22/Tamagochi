package com.tamagochi;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        System.out.println("Let's play Rock.. Paper.. Scissors!");

        String[] options = {"r", "p", "s"}; 
        String computerMove = options[new Random().nextInt(options.length)];

        Scanner scanner = new Scanner(System.in);
        String playerMove = "";

        while (true) {
            System.out.println("Please enter your move! Rock (r key), Paper (p key), or Scissors (s key)!");
            playerMove = scanner.nextLine();
            if (playerMove.equals("r") || playerMove.equals("p") || playerMove.equals("s")) {
                break;
            }
            System.out.println(playerMove + " was not a valid move");
        }
        
        System.out.println("Computer played: " + computerMove);
        
        if (playerMove.equals(computerMove)) {
            System.out.println("The game was a tie!");
        } else if (playerMove.equals("r")) {
            if (computerMove.equals("p")) {
                System.out.println("You lose!");
            } else if (computerMove.equals("s")) {
                System.out.println("You win!");
            }
        } else if (playerMove.equals("p")) {
            if (computerMove.equals("r")) {
                System.out.println("You win!");
            } else if (computerMove.equals("s")) {
                System.out.println("You lose!");
            }
        } else if (playerMove.equals("s")) {
            if (computerMove.equals("p")) {
                System.out.println("You win!");
            } else if (computerMove.equals("r")) {
                System.out.println("You lose!");
            }
        }
    }
}
