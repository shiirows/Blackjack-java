package com.wildcodeschool;

import java.util.Random;

public class Play {

    public static void main(String[] args) {
        do  {
            game();
        } while (UserInterface.doesPlayerContinues()) ;
    }

    public static void game() {
        int scorePlayer = 0;
        int scoreDealer = 0;

        scorePlayer = pickCard(scorePlayer, true);
        scorePlayer = pickCard(scorePlayer, true);
        scoreDealer = pickCard(scoreDealer, false);

        UserInterface.dealerHidesCard();

        while (scorePlayer < 21 && UserInterface.doesPlayerPicksCard()) {
            scorePlayer = pickCard(scorePlayer, true);
        }

        boolean playerWins = false;
        if (scorePlayer <= 21) {
            // TODO : better way to reveal the dealer card
            UserInterface.dealerRevealsCard();
            scoreDealer = pickCard(scoreDealer, false);

            while (scoreDealer < 17) {
                scoreDealer = pickCard(scoreDealer, false);
            }
        }

        if (scoreDealer > 21 || scorePlayer > scoreDealer) {
            playerWins = true;
        }
        UserInterface.gameOver(playerWins);
    }

    public static int pickCard(int score, boolean isPlayer) {
        int currentCard = createRandomCard();
        UserInterface.dealerGivesCard(isPlayer, currentCard);
        score += currentCard;
        UserInterface.showScore(isPlayer, score);

        return score;
    }

    public static int createRandomCard() {
        int card = new Random().nextInt(10) + 1;
        // TODO : face cards
        // TODO : ace (1 or 10)

        return card;
    }
    
   
}
