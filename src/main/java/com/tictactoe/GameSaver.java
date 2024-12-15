package com.tictactoe;

import java.io.*;

public class GameSaver {
    private final static String fileName = "saveGame.txt";

    // Zapisuje stan gry do pliku
    public static void saveGame(GameEngine gameEngine) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Board Size: " + gameEngine.getBoardSize());
            writer.newLine();
            writer.write("Current Player: " + (gameEngine.getIsPlayer2AI() ? "Player 1" : "Player 2"));
            writer.newLine();
            writer.write("Is AI Opponent: " + gameEngine.getIsPlayer2AI());
            writer.newLine();
            writer.write("Level: " + gameEngine.getLevel());
            writer.newLine();
            writer.write("Player 1: " + gameEngine.getPlayer1().getUserName());
            writer.newLine();
            writer.write("Player 2: " + (gameEngine.getIsPlayer2AI() ? "AI" : gameEngine.getPlayer2().getUserName()));
            writer.newLine();

            // Zapisanie planszy
            writer.write("Board: ");
            for (Integer cell : gameEngine.getGameBoard().getBoard()) {
                writer.write(cell + " ");
            }
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
        }
    }

    // Wczytuje stan gry z pliku
    public static GameEngine loadGame() throws IOException {
        GameEngine gameEngine = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // Board Size
            int boardSize = Integer.parseInt(line.split(": ")[1]);

            line = reader.readLine(); // Current Player
            String currentPlayer = line.split(": ")[1];

            line = reader.readLine(); // Is AI Opponent
            boolean isAI = Boolean.parseBoolean(line.split(": ")[1]);

            line = reader.readLine(); // Level
            int level = Integer.parseInt(line.split(": ")[1]);

            line = reader.readLine(); // Player 1
            String player1Name = line.split(": ")[1];

            line = reader.readLine(); // Player 2
            String player2Name = line.split(": ")[1];

            // Tworzymy nową instancję gry
            User player1 = new User(player1Name, 1);
            User player2 = isAI ? null : new User(player2Name, 2);

            gameEngine = new GameEngine(player1, player2, new ConsoleUI(), isAI, level, boardSize);

            // Wczytanie planszy
            line = reader.readLine(); // Board
            String[] boardState = line.split(": ")[1].split(" ");
            GameBoard gameBoard = new GameBoard(boardSize);
            for (int i = 0; i < boardState.length; i++) {
                gameBoard.addSymbol(i + 1, Integer.parseInt(boardState[i]));
            }
            gameEngine.setGameBoard(gameBoard);
            gameEngine.startGame();

        } catch (IOException e) {
            throw new IOException();

        }
        return gameEngine;
    }
}
