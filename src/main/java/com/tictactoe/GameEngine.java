package com.tictactoe;

public class GameEngine {
    private GameBoard gameBoard = new GameBoard();
    private User player1;
    private User player2;
    private boolean end = false;
    private UI ui;

    public GameEngine(User player1, User player2, UI ui) {
        this.player1 = player1;
        this.player2 = player2;
        this.ui = ui;
    }

    public void startGame() {
        gameBoard.resetBoard();
        ui.displayMessage("Game starting! " + player1.getUserName() + " vs " + player2.getUserName());
        while (!end) {
            gameBoard.fieldNumbers();
            playTurn(player1);
            if (checkGameEnd()) break;
            playTurn(player2);
            if (checkGameEnd()) break;
        }
    }

    private void playTurn(User player) {
        ui.displayMessage("It's " + player.getUserName() + "'s turn!");
        int position = ui.getSymbolFromUser();
        if (gameBoard.isCellAvailable(position)) {
            gameBoard.addSymbol(position, player.getPlayerNumber());
            gameBoard.printBoard();
        } else {
            ui.displayMessage("This cell is already taken. Please choose another one.");
            playTurn(player);
        }
    }

    private boolean checkGameEnd() {
        int winner = gameBoard.checkWinner();
        if (winner != 0 || !gameBoard.checkIfBoardFull()) {
            end = true;
            if (!gameBoard.checkIfBoardFull()) {
                ui.displayMessage("It's a draw!");
            } else {
                String winnerName = (winner == 1) ? player1.getUserName() : player2.getUserName();
                ui.displayMessage(winnerName + " wins!");
            }
        }
        return end;
    }
}