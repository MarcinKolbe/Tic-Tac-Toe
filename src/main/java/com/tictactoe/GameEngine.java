package com.tictactoe;

public class GameEngine {
    GameBoard gameBoard = new GameBoard();
    private boolean end = false;
    User player1 = new User();
    User player2 = new User();

    public void game() {
        int symbol;
        UserInterface ui = new UserInterface();
        gameBoard.resetBoard();
        ui.player1Name();
        player1.getUserNameFromUserInput();
        ui.player2Name();
        player2.getUserNameFromUserInput();
        gameBoard.fieldNumbers();
        while (!end) {
            ui.fieldNumber();
            while (true) {
                symbol = player1.getSymbolFromUserInput();
                if (gameBoard.isCellAvailable(symbol)) {
                    gameBoard.addSymbol(symbol, 1);
                    break;
                }
                ui.fieldTaken();
            }
            gameBoard.printBoard();
                if (gameBoard.checkWinner() != 0) {
                    end = true;
                    ui.playerWins(player1);
                    ui.endGame(player1, player2);
                    return;
                }
            ui.fieldNumber();
            while (true) {
                symbol = player1.getSymbolFromUserInput();
                if (gameBoard.isCellAvailable(symbol)) {
                    gameBoard.addSymbol(symbol, 2);
                    break;
                }
                ui.fieldTaken();
            }
            gameBoard.printBoard();
            if (gameBoard.checkWinner() != 0) {
                end = true;
                ui.playerWins(player2);
                ui.endGame(player1, player2);
                return;
            }
            if (!gameBoard.checkIfBoardFull()) {
                end = true;
                ui.itIsADraw();
                ui.endGame(player1, player2);
                return;
            }
        } end = false;
    }
}