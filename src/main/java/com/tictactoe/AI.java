package com.tictactoe;

import java.util.List;
import java.util.Random;

public class AI {

    public static int getBestMove(GameBoard gameBoard) {
        List<Integer> availablePositions = gameBoard.getAvailablePositions();
        Random rand = new Random();
        return availablePositions.get(rand.nextInt(availablePositions.size()));  // Losowy wybór z dostępnych
    }

}