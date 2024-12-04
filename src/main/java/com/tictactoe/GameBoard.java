package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    List<Integer> board = new ArrayList<>();
    private static final int[][] WINNING_COMBINATIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}  // diagonals
    };
    public void fieldNumbers() {
        for (int i = 1; i <= 9; i++) {
            System.out.print(" | " + i);
            if(i == 3 || i == 6 || i == 9) {
                System.out.println(" |");
            }
        }
    }
    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if(board.get(i) == 1) {
                System.out.print(" | O");
            } else if(board.get(i) == 2) {
                System.out.print(" | X");
            } else System.out.print(" | " + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println(" |");
            }
        }
    }
    public void resetBoard() {
        board.clear();
        for (int i=0; i<9; i++) {
            board.add(0);
        }
    }
    public boolean isCellAvailable(int symbol) {
        return board.get(symbol - 1) == 0;
    }
    public void addSymbol(int symbol, int player) {
        if (isCellAvailable(symbol)) {
            board.set(symbol - 1, player);
        } else {
            System.out.println("This cell is already occupied. Please choose another.");
        }
    }
    public boolean checkIfBoardFull() {
        return board.contains(0);
    }
    public int checkWinner() {
        for (int[] combination : WINNING_COMBINATIONS) {
            if (board.get(combination[0]) == board.get(combination[1]) &&
                    board.get(combination[1]) == board.get(combination[2]) &&
                    board.get(combination[0]) != 0) {
                return board.get(combination[0]);
            }
        }
        return 0;
    }
}