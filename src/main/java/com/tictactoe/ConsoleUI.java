package com.tictactoe;

import java.util.List;
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
    public void displayBoard(GameBoard gameBoard) {
        List<Integer> board = gameBoard.getBoard();
        for (int i = 0; i < 9; i++) {
            System.out.print(" | ");
            if (board.get(i) == 1) {
                System.out.print("O");
            } else if (board.get(i) == 2) {
                System.out.print("X");
            } else {
                System.out.print(" ");
            }
            if (i == 2 || i == 5 || i == 8) {
                System.out.println(" |");
            }
        }
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

    @Override
    public boolean askForOpponentType() {
        System.out.println("Do you want to play against another player or against the computer? (Enter 'player' or 'cpu')");
        String opponent = scanner.nextLine().trim().toLowerCase();
        return opponent.equals("cpu");
    }

    @Override
    public void displayFieldNumbers() {
        for (int i = 1; i <= 9; i++) {
            System.out.print(" | " + i);
            if (i == 3 || i == 6 || i == 9) {
                System.out.println(" |");
            }
        }
    }
}