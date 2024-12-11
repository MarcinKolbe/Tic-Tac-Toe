package com.tictactoe;

public interface UI {
    User getUserInput(int playerNumber);
    int getPositionFromUser();
    void displayBoard(GameBoard board);
    void displayMessage(String message);
    void endGameMessage(User winner);
    boolean askForOpponentType();
    void displayFieldNumbers();
    int getDifficultyLevel();
}
