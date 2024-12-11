package com.tictactoe;

public class GameEngine {
    private GameBoard gameBoard = new GameBoard();
    private User player1;
    private User player2;
    private boolean end = false;
    private UI ui;
    private boolean isPlayer2AI;
    private int level;

    public GameEngine(User player1, User player2, UI ui, boolean isPlayer2AI, int level) {
        this.player1 = player1;
        this.player2 = player2;
        this.ui = ui;
        this.isPlayer2AI = isPlayer2AI;
        this.level = level;
    }

    public void startGame() {
        gameBoard.resetBoard();
        ui.displayMessage("Game starting! " + player1.getUserName() + " vs " + (isPlayer2AI ? "CPU" : player2.getUserName()));
        while (!end) {
            ui.displayFieldNumbers();
            playTurn(player1);
            if (checkGameEnd()) break;
            if (isPlayer2AI) {
                playAITurn();
            } else playTurn(player2);
            if (checkGameEnd()) break;
        }
    }

    private void playTurn(User player) {
        ui.displayMessage("It's " + player.getUserName() + "'s turn!");
        int position = ui.getPositionFromUser();
        if (gameBoard.isCellAvailable(position)) {
            gameBoard.addSymbol(position, player.getPlayerNumber());
            ui.displayBoard(gameBoard);
        } else {
            ui.displayMessage("This cell is already taken. Please choose another one.");
            playTurn(player);
        }
    }

    private boolean checkGameEnd() {
        int winner = gameBoard.checkWinner();
        if (winner != 0 || !gameBoard.checkIfBoardFull()) {
            end = true;
            if (winner == 0 && !gameBoard.checkIfBoardFull()) {
                ui.displayMessage("It's a draw!");
            } else {
                String winnerName = (winner == 1) ? player1.getUserName() : (isPlayer2AI ? "Computer" : player2.getUserName());
                ui.displayMessage(winnerName + " wins!");
            }
        }
        return end;
    }

    private void playAITurn() {
        int position = AI.getBestMove(gameBoard, level);
        ui.displayMessage("Computer chooses position " + position);
        gameBoard.addSymbol(position, 2);
        ui.displayBoard(gameBoard);
    }
}