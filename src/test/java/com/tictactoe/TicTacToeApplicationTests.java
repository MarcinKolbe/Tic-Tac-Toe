package com.tictactoe;

import org.junit.jupiter.api.*;

@DisplayName("Tic Tac Toe Test Suite")
public class TicTacToeApplicationTests {
    private static int testCounter = 0;

    @BeforeAll
    static void beforeAll() {
        System.out.println("This is the beginning of tests");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("All tests are finished!");
    }
    @BeforeEach
    void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    void player1WinsIn1stRow() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(1,1);
        gameBoard.addSymbol(2,1);
        gameBoard.addSymbol(3,1);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    void player1WinsIn2ndRow() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(4,1);
        gameBoard.addSymbol(5,1);
        gameBoard.addSymbol(6,1);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    void player1WinsIn3rdRow() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(7,1);
        gameBoard.addSymbol(8,1);
        gameBoard.addSymbol(9,1);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    void player1WinsIn1stColumn() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(1,1);
        gameBoard.addSymbol(4,1);
        gameBoard.addSymbol(7,1);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    void player1WinsIn2ndColumn() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(2,1);
        gameBoard.addSymbol(5,1);
        gameBoard.addSymbol(8,1);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    void player1WinsIn3rdColumn() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(3,1);
        gameBoard.addSymbol(6,1);
        gameBoard.addSymbol(9,1);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    void player1WinsIn1stDiagonal() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(1,1);
        gameBoard.addSymbol(5,1);
        gameBoard.addSymbol(9,1);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    void player1WinsIn2ndDiagonal() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(3,1);
        gameBoard.addSymbol(5,1);
        gameBoard.addSymbol(7,1);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    void player2WinsIn1stRow() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(1,2);
        gameBoard.addSymbol(2,2);
        gameBoard.addSymbol(3,2);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(2,result);
    }
    @Test
    void player2WinsIn2ndRow() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(4,2);
        gameBoard.addSymbol(5,2);
        gameBoard.addSymbol(6,2);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(2,result);
    }
    @Test
    void player2WinsIn3rdRow() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(7,2);
        gameBoard.addSymbol(8,2);
        gameBoard.addSymbol(9,2);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(2,result);
    }
    @Test
    void player2WinsIn1stColumn() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(1,2);
        gameBoard.addSymbol(4,2);
        gameBoard.addSymbol(7,2);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(2,result);
    }
    @Test
    void player2WinsIn2ndColumn() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(2,2);
        gameBoard.addSymbol(5,2);
        gameBoard.addSymbol(8,2);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(2,result);
    }
    @Test
    void player2WinsIn3rdColumn() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(3,2);
        gameBoard.addSymbol(6,2);
        gameBoard.addSymbol(9,2);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(2,result);
    }
    @Test
    void player2WinsIn1stDiagonal() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(1,2);
        gameBoard.addSymbol(5,2);
        gameBoard.addSymbol(9,2);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(2,result);
    }
    @Test
    void player2WinsIn2ndDiagonal() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(3,2);
        gameBoard.addSymbol(5,2);
        gameBoard.addSymbol(7,2);
        //When
        int result = gameBoard.checkWinner();
        //Then
        Assertions.assertEquals(2,result);
    }
    @Test
    void ItIsADraw() {
        //Given
        GameBoard gameBoard = new GameBoard(3);
        gameBoard.resetBoard();
        gameBoard.addSymbol(1,1);
        gameBoard.addSymbol(2,2);
        gameBoard.addSymbol(3,1);
        gameBoard.addSymbol(4,2);
        gameBoard.addSymbol(5,2);
        gameBoard.addSymbol(6,1);
        gameBoard.addSymbol(7,1);
        gameBoard.addSymbol(8,1);
        gameBoard.addSymbol(9,2);
        //When
        int result = gameBoard.checkWinner();
        boolean fullBoard = gameBoard.checkIfBoardFull();
        //Then
        Assertions.assertEquals(0,result);
        Assertions.assertFalse(fullBoard);
    }
}