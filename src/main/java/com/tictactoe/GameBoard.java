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

    public void printBoard() {
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
    public boolean isCellAvailable(int position) {
        return board.get(position - 1) == 0;
    }
    public void fieldNumbers() {
        for (int i = 1; i <= 9; i++) {
            System.out.print(" | " + i);
            if (i == 3 || i == 6 || i == 9) {
                System.out.println(" |");
            }
        }
    }
}