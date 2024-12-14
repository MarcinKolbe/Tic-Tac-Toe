package com.tictactoe;

public class TicTacToeApplication {

    public static void main(String[] args) {

        UI ui = new ConsoleUI(); // Możliwość łatwej zmiany na inne UI (np. new GUI())
        ui.startGame();
    }
}