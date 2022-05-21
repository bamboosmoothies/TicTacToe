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
            d = checkGameBoard(gameBoard);

        }
        System.out.println("Replay again? Enter Y/N");
        char dook = scan.nextLine().charAt(0);
        if (dook == 'Y' || dook == 'y') {
            d = false;
        }
        System.exit(0);
        

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
            int botX = (int) (Math.random() * 3) + 1;
            int boxY = (int) (Math.random() * 3) + 1;
            
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
                    if (!(gameBoard[i][j] == 'X') && (!(gameBoard[i][j] == 'O'))) {
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
    
    public static boolean checkGameBoard(char[][] gameBoard) {
        //scans Row
        int total = 0;
        int totalBot = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {

                if(gameBoard[i][j] == 'X') {
                    total = total + 3;
                }
                
                if(gameBoard[i][j] == 'O') {
                    totalBot = totalBot + 3;
                }
            }
        }
        for (int i = 2; i > gameBoard.length; i--) {
            for (int j = 0; j < gameBoard.length; j++) {

                if (gameBoard[i][j] == 'X') {
                    total = total + 3;
                }
                
                if(gameBoard[i][j] == 'O') {
                totalBot = totalBot + 3;
                }
            }

        }
        
        if(total == 9) {
            System.out.println("\nYOU WIN!");
            return false;
        }
        else if (totalBot == 9) {
            System.out.println("\nYOU LOSE!");
            return false;
        }
        else if (total != totalBot) {
            System.out.println("Stalemate...");
            return false;
        }
        return true;

    }
    


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    

