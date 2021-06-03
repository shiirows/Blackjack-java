package com.wildcodeschool;

import java.util.Scanner;

public class UserInterface {

    public static void gameOver(boolean playerWins) {
        if (playerWins) {
            System.out.println("Congratulation, you win!");
        } else {
            System.out.println("You lose!");
        }
    }

    public static boolean doesPlayerContinues() {
        System.out.println("Play again? (y/n)");
        Scanner sc = new Scanner(System.in);
        String entry = sc.next();
        return entry.equalsIgnoreCase("y");
    }

    public static boolean doesPlayerPicksCard() {
        System.out.println("Pick a new card? (y/n)");
        Scanner sc = new Scanner(System.in);
        String entry = sc.next();
        return entry.equalsIgnoreCase("y");
    }

    public static void dealerHidesCard() {
        System.out.println("Dealer picks a face down card.");
    }

    public static void dealerRevealsCard() {
        System.out.println("Dealer reveals his face down card.");
    }

    public static void dealerGivesCard(boolean isPlayer, int card) {
        if (isPlayer) {
            System.out.println("Dealer gives a card to the player: " + card);
        } else {
            System.out.println("Dealer gives a card to himself: " + card);
        }
    }

    public static void showScore(boolean isPlayer, int score) {
        if (isPlayer) {
            System.out.println("Player score is: " + score);
        } else {
            System.out.println("Dealer score is: " + score);
        }
    }
}
