package com.tictactoe;

import java.util.Scanner;

public class ConsoleUI implements UI {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public User getUserInput(int playerNumber) {
        System.out.println("Enter name for Player " + playerNumber + ": ");
        String name = scanner.nextLine();
        return new User(name, playerNumber);
    }

    @Override
    public int getSymbolFromUser() {
        int position = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter the position (1-9) where you want to place your symbol: ");
            try {
                position = Integer.parseInt(scanner.nextLine());
                if (position < 1 || position > 9) {
                    System.out.println("Invalid input! Please enter a number between 1 and 9.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        return position;
    }

    @Override
    public void displayBoard(GameBoard board) {
        board.printBoard();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void endGameMessage(User winner) {
        if (winner != null) {
            System.out.println("Player " + winner.getUserName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
