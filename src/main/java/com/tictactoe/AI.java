package com.tictactoe;

import java.util.List;
import java.util.Random;

public class AI {

    public static int getBestMove(GameBoard gameBoard, int level) {
        return switch (level) {
            case 1 -> getRandomMove(gameBoard);
            case 2 -> getMediumMove(gameBoard);
            case 3 -> minimax(gameBoard);
            default -> throw new IllegalArgumentException();
        };
    }

    public static int getRandomMove(GameBoard gameBoard) {
        List<Integer> availablePositions = gameBoard.getAvailablePositions();
        Random rand = new Random();
        return availablePositions.get(rand.nextInt(availablePositions.size()));  // Losowy wybór z dostępnych
    }

    public static int getMediumMove(GameBoard gameBoard) {
        // 1. Jeśli cpu może wygrać, wybierz ruch wygrywający
        int winningMove = findWinningMove(gameBoard, 2);  // Sprawdź, czy cpu może wygrać
        if (winningMove != -1) {
            return winningMove;
        }

        // 2. Jeśli player1 może wygrać, blokuj jego ruch
        int blockingMove = findWinningMove(gameBoard, 1);  // Sprawdź, czy player1 może wygrać
        if (blockingMove != -1) {
            return blockingMove;
        }

        // 3. Jeśli dostępna jest centralna pozycja, wybierz ją
        if (gameBoard.isCellAvailable(5)) {
            return 5;  // Centralna komórka
        }

        // 4. Wybierz ruch w rogu, jeśli dostępny
        int[] corners = {1, 3, 7, 9};
        for (int corner : corners) {
            if (gameBoard.isCellAvailable(corner)) {
                return corner;
            }
        }

        // 5. Wybierz dowolny dostępny ruch
        return getRandomMove(gameBoard);
    }

    public static int minimax(GameBoard gameBoard) {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE;

        // Przejdź przez wszystkie dostępne pozycje
        List<Integer> availablePositions = gameBoard.getAvailablePositions();
        for (int position : availablePositions) {
            gameBoard.addSymbol(position, 2);  // Zrób ruch
            int score = minimaxScore(gameBoard, false);  // Oblicz wynik dla tego ruchu
            gameBoard.addSymbol(position, 0);  // Cofnij ruch

            // Jeśli wynik tego ruchu jest lepszy, zapisz go
            if (score > bestScore) {
                bestScore = score;
                bestMove = position;
            }
        }

        return bestMove;
    }

    private static int findWinningMove(GameBoard gameBoard, int playerNumber) {
        List<Integer> availablePositions = gameBoard.getAvailablePositions();
        for (int position : availablePositions) {
            gameBoard.addSymbol(position, playerNumber);
            if (gameBoard.checkWinner() == playerNumber) {
                gameBoard.addSymbol(position, 0);  // Cofnij ruch
                return position;
            }
            gameBoard.addSymbol(position, 0);  // Cofnij ruch
        }
        return -1;  // Brak wygrywającego ruchu
    }

    // Funkcja oceny dla minimax
    private static int minimaxScore(GameBoard gameBoard, boolean isMaximizingPlayer) {
        int winner = gameBoard.checkWinner();
        if (winner == 2) {
            return 1;  // Komputer wygrał
        } else if (winner == 1) {
            return -1;  // Gracz wygrał
        } else if (!gameBoard.checkIfBoardFull()) {
            return 0;  // Remis, gra jeszcze trwa
        }

        List<Integer> availablePositions = gameBoard.getAvailablePositions();
        if (isMaximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            for (int position : availablePositions) {
                gameBoard.addSymbol(position, 2);  // Zrób ruch
                bestScore = Math.max(bestScore, minimaxScore(gameBoard, false));  // Minimax dla gracza
                gameBoard.addSymbol(position, 0);  // Cofnij ruch
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int position : availablePositions) {
                gameBoard.addSymbol(position, 1);  // Zrób ruch
                bestScore = Math.min(bestScore, minimaxScore(gameBoard, true));  // Minimax dla cpu
                gameBoard.addSymbol(position, 0);  // Cofnij ruch
            }
            return bestScore;
        }
    }
}