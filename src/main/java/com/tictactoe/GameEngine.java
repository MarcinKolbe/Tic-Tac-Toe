package com.tictactoe;

public class GameEngine {
    private GameBoard gameBoard;
    private User player1;
    private User player2;
    private boolean end = false;
    private UI ui;
    private boolean isPlayer2AI;
    private int level;
    private int boardSize;

    public GameEngine(User player1, User player2, UI ui, boolean isPlayer2AI, int level, int boardSize) {
        this.player1 = player1;
        this.player2 = player2;
        this.ui = ui;
        this.isPlayer2AI = isPlayer2AI;
        this.level = level;
        this.boardSize = boardSize;
        this.gameBoard = new GameBoard(boardSize);
    }

    public void startGame() {
        gameBoard.resetBoard();
        ui.displayMessage("Game starting! " + player1.getUserName() + " vs " + (isPlayer2AI ? "CPU" : player2.getUserName()) + ((boardSize == 3)?" - 3 symbols next to each other win": " - 5 symbols next to each other win"));
        while (!end) {
            ui.displayFieldNumbers(boardSize);
            playTurn(player1);
            if (checkGameEnd()) break;
            if (isPlayer2AI) {
                playAITurn();
                if (checkGameEnd()) break;
            } else playTurn(player2);
            if (checkGameEnd()) break;
        }
    }

    private void playTurn(User player) {
        ui.displayMessage("It's " + player.getUserName() + "'s turn!");
        int position = ui.getPositionFromUser(boardSize);
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
            ui.endGameMessage();
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