package com.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {
    private List<Integer> board;
    private int boardSize;

    public GameBoard(int boardSize) {
        this.boardSize = boardSize;
        this.board = new ArrayList<>(Collections.nCopies(boardSize * boardSize, 0));
    }
    public void resetBoard() {
        Collections.fill(board, 0);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void addSymbol(int position, int playerNumber) {
        board.set(position - 1, playerNumber);
    }

    public boolean checkIfBoardFull() {
        return board.contains(0);
    }

    public int checkWinner() {
        // Liczba symboli w linii potrzebna do wygranej (3 dla 3x3, 5 dla 10x10)
        int symbolsToWin = (boardSize == 3) ? 3 : 5;

        // Sprawdzamy wygrane w poziomie, pionie i przekątnych
        // Poziomo
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col <= boardSize - symbolsToWin; col++) {
                int first = board.get(row * boardSize + col);
                if (first != 0 && checkLine(row, col, 0, 1, symbolsToWin, first)) {
                    return first;  // Zwracamy numer gracza
                }
            }
        }

        // Pionowo
        for (int col = 0; col < boardSize; col++) {
            for (int row = 0; row <= boardSize - symbolsToWin; row++) {
                int first = board.get(row * boardSize + col);
                if (first != 0 && checkLine(row, col, 1, 0, symbolsToWin, first)) {
                    return first;  // Zwracamy numer gracza
                }
            }
        }

        // Przekątne (lewo-prawo)
        for (int row = 0; row <= boardSize - symbolsToWin; row++) {
            for (int col = 0; col <= boardSize - symbolsToWin; col++) {
                int first = board.get(row * boardSize + col);
                if (first != 0 && checkLine(row, col, 1, 1, symbolsToWin, first)) {
                    return first;  // Zwracamy numer gracza
                }
            }
        }

        // Przekątne (prawo-lewo)
        for (int row = 0; row <= boardSize - symbolsToWin; row++) {
            for (int col = symbolsToWin - 1; col < boardSize; col++) {
                int first = board.get(row * boardSize + col);
                if (first != 0 && checkLine(row, col, 1, -1, symbolsToWin, first)) {
                    return first;  // Zwracamy numer gracza
                }
            }
        }

        return 0;  // Brak zwycięzcy
    }

    // Metoda sprawdzająca linię dla zadanej długości
    private boolean checkLine(int row, int col, int rowDir, int colDir, int length, int player) {
        for (int i = 0; i < length; i++) {
            int r = row + i * rowDir;
            int c = col + i * colDir;
            if (board.get(r * boardSize + c) != player) {
                return false;  // Jeśli na jakiejkolwiek pozycji nie ma odpowiedniego symbolu, zwrócimy fałsz
            }
        }
        return true;  // Jeśli wszystkie symbole w linii są równe, zwrócimy prawdę
    }

    public boolean isCellAvailable(int position) {
        return board.get(position - 1) == 0;
    }

    public List<Integer> getAvailablePositions() {
        List<Integer> availablePositions = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i) == 0) {
                availablePositions.add(i + 1);  // Dodaje pozycję numerowana od 1
            }
        }
        return availablePositions;
    }

    public List<Integer> getBoard() {
        return board;
    }

}