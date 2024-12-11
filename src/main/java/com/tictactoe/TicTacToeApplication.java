package com.tictactoe;

public class TicTacToeApplication {

    public static void main(String[] args) {

        UI ui = new ConsoleUI(); // Możliwość łatwej zmiany na inne UI (np. new GUI())
        boolean isPlayer2AI = ui.askForOpponentType();
        int level = -1;
        if (isPlayer2AI) {
            level = ui.getDifficultyLevel();
        }

        User player1 = ui.getUserInput(1);
        User player2 = null;
        if (!isPlayer2AI) {
            player2 = ui.getUserInput(2);
        }

        GameEngine gameEngine = new GameEngine(player1, player2, ui, isPlayer2AI, level);
        gameEngine.startGame();
    }
}