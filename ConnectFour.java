import java.util.Scanner;

public class ConnectFour {


    public static void printBoard(char[][] array) {    //Print the board
        for (int col = array[0].length - 1; col >= 0; col--) {
            for (int row = 0; row < array.length; row++) {
                System.out.print(array[row][col] + " ");
                if (row == array.length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public static void initializeBoard(char[][] array) {   //Set each spot in the array to "-"
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = '-';
            }
        }
    }

    public static char[][] insertChip(char[][] array, int col, char chipType) { //Places the token in the column that the user has chosen
        for (int row = 0; row < array[0].length; row++) {
            if (array[col][row] == '-') {
                array[col][row] = chipType;
                break;
            }
        }
        return array;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType)
    {


        /*
        int k = 0;
        for (int row = 0; row < array[0].length; row++) {//For-loop checks the column
            col = true;
            row = true;
            if (array[col][row] == chipType) {
                k++;
                if (k == 4) {
                    return true;
                }
            }
            else k = 0;
        }
        k = 0;
        for (int r = 0; r < array.length; r++) {             //For-loop checks the row
            if (array[r][row] == chipType) {
                k++;
                if (k == 4) {
                    return true;
                }
            }
            else k = 0;
        }
        return false;
    } */

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        boolean gameCheck = true;
        int playerTurn = 1;
        int endk = 0;
        int ks = 0;
        char chipType = 'n';
        System.out.print("What would you like the height of the board to be? ");
        int boardHeight = userInput.nextInt();                                     //User chooses the height
        System.out.print("What would you like the length of the board to be? ");
        int boardLength = userInput.nextInt();                                     //User chooses the length
        char[][] boardArray = new char[boardLength][boardHeight];
        initializeBoard(boardArray);
        printBoard(boardArray);
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        while (gameCheck == true) {
            System.out.print("Player " + playerTurn + ": Which column would you like to choose? ");
            int col = userInput.nextInt();
            for (int row = 0; row < boardArray[0].length; row++) {
                if (boardArray[col][row] == '-') {
                    ks = row;
                    break;
                }
            }
            if (playerTurn == 1) {
                chipType = 'x';
            }
            else if (playerTurn == 2) {
                chipType = 'o';
            }
            boardArray = insertChip(boardArray, col, chipType);                 //Method call to place the token in the column
            if (playerTurn == 1) {
                playerTurn = 2;
            }
            else if (playerTurn == 2) {
                playerTurn = 1;
            }
            printBoard(boardArray);
            if (checkIfWinner(boardArray, col, ks, chipType)) {                //Method call to check if there is a winner
                System.out.println("Player " + ((chipType == 'x') ? '1':'2') + " won the game!");
                System.exit(0);
            }
            endk++;
            if (boardHeight * boardLength  == endk) {
                System.out.println("Draw. Nobody wins.");
                System.exit(0);
            }
        }
    }
}
