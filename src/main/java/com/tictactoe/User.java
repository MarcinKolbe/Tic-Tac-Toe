package com.tictactoe;

import java.util.Scanner;

public class User {
    private String userName;
    private int symbol;

    public String getUserName() {
        return userName;
    }
    public String getUserNameFromUserInput() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextLine()) {
            System.out.println("Invalid input. Please enter a valid name.");
            sc.next();
        }
        userName = sc.nextLine();
        return userName;
    }
    public int getSymbol() {
        return symbol;
    }
    public int getSymbolFromUserInput() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number between 1 and 9.");
            sc.next();
        }
        symbol = sc.nextInt();
        return symbol;
    }
}
