package com.tictactoe;

public interface UI {
    User getUserInput(int playerNumber);
    int getPositionFromUser(int boardSize);
    void displayBoard(GameBoard board);
    void displayMessage(String message);
    void endGameMessage();
    boolean askForOpponentType();
    void displayFieldNumbers(int boardSize);
    int getDifficultyLevel();
    int getBoardSize();
    void startGame();
}
