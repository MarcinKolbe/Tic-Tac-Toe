package com.tictactoe;

public class PlayerStats {
    private String userName;
    private int gamesPlayed;
    private int gamesWon;
    private String date;

    public PlayerStats(String playerName) {
        this.userName = playerName;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.date = "";
    }

    public PlayerStats(String playerName, int gamesPlayed, int gamesWon, String date) {
        this.userName = playerName;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }

    public void incrementGamesWon() {
        this.gamesWon++;
    }

    @Override
    public String toString() {
        return userName + "|" + gamesPlayed + "|" + gamesWon + "|" + date;
    }
}
