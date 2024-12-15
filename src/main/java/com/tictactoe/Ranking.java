package com.tictactoe;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ranking {
    private List<PlayerStats> rankingList;
    private final String fileName = "rankingList.txt";

    public Ranking() {
        rankingList = loadRankingFromFile();
    }

    // Ładowanie danych z pliku
    public List<PlayerStats> loadRankingFromFile() {
        List<PlayerStats> stats = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4) {
                    String name = data[0];
                    int gamesPlayed = Integer.parseInt(data[1]);
                    int gamesWon = Integer.parseInt(data[2]);
                    String date = data[3];
                    stats.add(new PlayerStats(name, gamesPlayed, gamesWon, date));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading ranking file.");
        }
        return stats;
    }

    // Zapisanie wyników do pliku
    public void saveRankingToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (PlayerStats stats : rankingList) {
                writer.write(stats.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving ranking to file.");
        }
    }

    // Dodawanie nowego wyniku do rankingu
    public void addPlayerStats(String userName, boolean won) {
        PlayerStats stats = findPlayerStats(userName);
        if (stats == null) {
            stats = new PlayerStats(userName);
            rankingList.add(stats);
        }
        stats.incrementGamesPlayed();
        if (won) {
            stats.incrementGamesWon();
        }
        stats.setDate(getCurrentDate());
        saveRankingToFile();
    }

    // Szukamy statystyk gracza w rankingu
    private PlayerStats findPlayerStats(String userName) {
        for (PlayerStats stats : rankingList) {
            if (stats.getUserName().equals(userName)) {
                return stats;
            }
        }
        return null;
    }

    // Pobranie bieżącej daty w formacie YYYY-MM-DD
    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public List<PlayerStats> getRankingList() {
        return rankingList;
    }


}
