import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author School
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        char[][] gameBoard = { 
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
        };
            
        boolean d = true;
        while(d) {
            printPlayerTurn();
            runPlayerTurn(gameBoard);

            //Bot play
            printBotsTurn();
            runBotsTurn(gameBoard);
            
            //Verify stalemate
            //TODO!!!
            checkGameBoard(gameBoard);
        
//        d = false;
        }   
        

    } 
    
    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    public static void runPlayerTurn(char[][] gameBoard) throws InterruptedException {
        boolean test = true;
        while(test) {
            Scanner scan = new Scanner(System.in);
            printGameBoard(gameBoard);
            System.out.println("\nEnter X position (1-3):");
            int posX = scan.nextInt();
            System.out.println("Enter Y position (1-3):");
            int posY = scan.nextInt();    

            if(posX == 1) {
                if (posY == 1){posX = 0; posY = 0;}
                if (posY == 2){posX = 0; posY = 2;}
                if (posY == 3){posX = 0; posY = 4;}        
            }       
            if(posX == 2) {
                if (posY == 1){posX = 2; posY = 0;}
                if (posY == 2){posX = 2; posY = 2;}
                if (posY == 3){posX = 2; posY = 4;}          
            }  
            if(posX == 3) {
                if (posY == 1){posX = 4; posY = 0;}
                if (posY == 2){posX = 4; posY = 2;}
                if (posY == 3){posX = 4; posY = 4;}         
            }

            for (int i = posX; i == posX; i++) {
                for (int j = posY; j == posY; j++) {
                    if ((gameBoard[i][j] == 'X')) {
                        System.out.println("You cannot occupy your own spot. Re-enter your coordinates.");
                        test = true;
                    }                    
                    else if (!(gameBoard[i][j] == 'O')) {
                        gameBoard[i][j] = 'X';
                        printGameBoard(gameBoard);
                        test = false;
                    }
                    else {
                        System.out.println("You cannot occupy an opponent's spot. Re-enter your coordinates.");
                        Thread.sleep(2000);
                        test = true;       
                    }
                }
            }
        }
    }
    
    public static void runBotsTurn(char[][] gameBoard) {
        boolean test = true;
        while(test) {
            int botX = (int) (Math.random() * 2 + 1);
            int boxY = (int) (Math.random() * 2 + 1);
            
            if(botX == 1) {
                if (boxY == 1){botX = 0; boxY = 0;}
                if (boxY == 2){botX = 0; boxY = 2;}
                if (boxY == 3){botX = 0; boxY = 4;}        
            }       
            if(botX == 2) {
                if (boxY == 1){botX = 2; boxY = 0;}
                if (boxY == 2){botX = 2; boxY = 2;}
                if (boxY == 3){botX = 2; boxY = 4;}          
            }  
            if(botX == 3) {
                if (boxY == 1){botX = 4; boxY = 0;}
                if (boxY == 2){botX = 4; boxY = 2;}
                if (boxY == 3){botX = 4; boxY = 4;}         
            }

            for (int i = botX; i == botX; i++) {
                for (int j = boxY; j == boxY; j++) {
                    if (!(gameBoard[i][j] == 'X')) {
                        gameBoard[i][j] = 'O';
                        printGameBoard(gameBoard);
                        test = false;
                    }
                    else {
                        test = true;
                    }
                }
            }
        }
    }
    
    public static void printBotsTurn() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("\nComputer's Turn!\n");
        Thread.sleep(1500);
    }
    
    public static void printPlayerTurn() throws InterruptedException {
        System.out.println("\nPlayer's Turn!\n");
    }
    
    public static void checkGameBoard(char[][] gameBoard) {
        
    
        
        
    }
    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    

