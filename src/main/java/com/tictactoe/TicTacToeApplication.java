package com.tictactoe;

public class TicTacToeApplication {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        ui.startGame(new GameEngine());

    }

}