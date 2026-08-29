package week1.class_problems;

import java.util.Random;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computerMoves = {"Scissors", "Paper", "Rock", "Scissors", "Rock"};

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < playerMoves.length; i++) {
            String result = playRound(playerMoves[i], computerMoves[i]);
            System.out.println("Round " + (i + 1) + " — Player: " + playerMoves[i] + ", Computer: " + computerMoves[i] + " -> " + result);
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPct = (double) wins / playerMoves.length * 100;
        System.out.println("Final Summary: Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPct + "%");
    }
}
