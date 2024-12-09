package com.tictactoe;

public interface UI {
    User getUserInput(int playerNumber);
    int getSymbolFromUser();
    void displayBoard(GameBoard board);
    void displayMessage(String message);
    void endGameMessage(User winner);
}
