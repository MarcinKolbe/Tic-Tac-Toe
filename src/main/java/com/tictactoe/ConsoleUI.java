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
    public int getPositionFromUser(int boardSize) {
        int position = -1;
        String numbersToChooseFrom = (boardSize == 3) ? "(1-9)":"(1-100)";
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter the position " + numbersToChooseFrom +  " where you want to place your symbol: ");
            try {
                position = Integer.parseInt(scanner.nextLine());
                if (boardSize == 3 && (position < 1 || position > 9) || boardSize == 10 && (position < 1 || position > 100)) {
                    System.out.println("Invalid input! Please enter a number between " + numbersToChooseFrom);
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
        for (int i = 0; i < gameBoard.getBoard().size(); i++) {
            System.out.print(" | ");
            if (board.get(i) == 1) {
                System.out.print("O");
            } else if (board.get(i) == 2) {
                System.out.print("X");
            } else {
                System.out.print(" ");
            }
            if ((i+1) % gameBoard.getBoardSize() == 0 && i != 0) {
                System.out.println(" |");
            }
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void endGameMessage() {
        System.out.println("Thank you for playing tic-tac-toe!");
    }

    @Override
    public boolean askForOpponentType() {
        System.out.println("Do you want to play against another player or against the computer? (Enter 'player' or 'cpu')");
        String opponent = scanner.nextLine().trim().toLowerCase();
        return opponent.equals("cpu");
    }

    @Override
    public void displayFieldNumbers(int boardSize) {
        for (int i = 1; i <=(boardSize*boardSize) ; i++) {
            System.out.print(" | " + i);
            if (i % boardSize == 0) {
                System.out.println(" |");
            }
        }
    }

    @Override
    public int getDifficultyLevel() {
        int level = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Select difficulty level (number 1-3) for CPU: 1 for Easy, 2 for Medium, 3 for Hard");
            try {
                level = scanner.nextInt();
                scanner.nextLine();
                if (level < 1 || level > 3) {
                    System.out.println("Invalid input! Please enter a number between 1 and 3.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        return level;
    }

    @Override
    public int getBoardSize() {
        int boardSize = -1;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter board size: 3 for standard board, 10 for hard board");
            try {
                boardSize = scanner.nextInt();
                scanner.nextLine();
                if (boardSize == 3 || boardSize == 10) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input! Please enter 3 or 10");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        return boardSize;
    }

    @Override
    public void startGame() {
        System.out.println("Welcome to Tic Tac Toe!");
        UI ui = new ConsoleUI();
        int boardSize = getBoardSize();
        boolean isPlayer2AI = askForOpponentType();
        int level = -1;
        if (isPlayer2AI) {
            level = getDifficultyLevel();
        }

        User player1 = getUserInput(1);
        User player2 = null;
        if (!isPlayer2AI) {
            player2 = getUserInput(2);
        }

        GameEngine gameEngine = new GameEngine(player1, player2, ui, isPlayer2AI, level, boardSize);
        gameEngine.startGame();
    }
}