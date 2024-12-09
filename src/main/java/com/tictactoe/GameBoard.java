package com.tictactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {
    private List<Integer> board = new ArrayList<>(Collections.nCopies(9, 0));

    public void resetBoard() {
        Collections.fill(board, 0);
    }

    public void addSymbol(int position, int playerNumber) {
        board.set(position - 1, playerNumber);
    }

    public boolean checkIfBoardFull() {
        return board.contains(0);
    }

    public int checkWinner() {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6} // diagonals
        };

        for (int[] pattern : winPatterns) {
            int first = board.get(pattern[0]);
            if (first != 0 && first == board.get(pattern[1]) && first == board.get(pattern[2])) {
                return first; // 1 or 2 (player number)
            }
        }
        return 0; // No winner
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