package com.tictactoe;

public class User {
    private String userName;
    private int playerNumber; // 1 for Player 1, 2 for Player 2

    public User(String userName, int playerNumber) {
        this.userName = userName;
        this.playerNumber = playerNumber;
    }

    public String getUserName() {
        return userName;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}