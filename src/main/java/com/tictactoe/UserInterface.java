package com.tictactoe;

import java.util.Scanner;

public class UserInterface{
    Scanner sc = new Scanner(System.in);

    public void startGame(GameEngine gameEngine) {
        System.out.println("Welcome to Tic-Tac-Toe!\n Please enter the name of the first and second player");
        gameEngine.game();
    }
    public void endGame(User user, User user2) {
        System.out.println("Thank you for playing " + user.getUserName() + " and " + user2.getUserName());
    }
    public void playerWins(User user) {
        System.out.println(user.getUserName() + " has won the game!");
    }
    public void itIsADraw() {
        System.out.println("It's a draw!");
    }
    public void player1Name() {
        System.out.println("Enter name for player1: ");
    }
    public void player2Name() {
        System.out.println("Enter name for player2: ");
    }
    public void fieldNumber() {
        System.out.println("Enter the number (1-9) of the empty field where you want to place your symbol");
    }
    public void fieldTaken() {
       System.out.println("This field is already taken. Please choose another.");
    }
}
