import java.util.Scanner;

class TicTacToe {

    static Scanner input = new Scanner(System.in);

    public static void resetBoard(char[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = ' ';
            }
        }
    }

    public static boolean isGameOver(char[][] gameBoard) {
        // Check for a win horizontally, vertically, or diagonally
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][0] != ' ') {
                System.out.println(gameBoard[i][0] + " wins!");
                return true;
            }
            if (gameBoard[0][i] == gameBoard[1][i] && gameBoard[1][i] == gameBoard[2][i] && gameBoard[0][i] != ' ') {
                System.out.println(gameBoard[0][i] + " wins!");
                return true;
            }
        }
        if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != ' ') {
            System.out.println(gameBoard[0][0] + " wins!");
            return true;
        }
        if (gameBoard[0][2] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][0] && gameBoard[0][2] != ' ') {
            System.out.println(gameBoard[0][2] + " wins!");
            return true;
        }

        // Check for a tie
        boolean isTie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    isTie = false;
                    break;
                }
            }
        }
        if (isTie) {
            System.out.println("It's a tie!");
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static void playerMove(char[][] gameBoard, char currentPlayer) {
        System.out.println("Player " + currentPlayer + ", make your move (row and column, e.g., 1 2): ");
        int row = input.nextInt() - 1;
        int col = input.nextInt() - 1;

        if (row >= 0 && row < 3 && col >= 0 && col < 3 && gameBoard[row][col] == ' ') {
            gameBoard[row][col] = currentPlayer;
        } else {
            System.out.println("Invalid move. Try again.");
            playerMove(gameBoard, currentPlayer);
        }
    }

    public static void main(String[] args) {
        char[][] gameBoard = new char[3][3];
        resetBoard(gameBoard);
        char currentPlayer = 'X';

        boolean gameOver = false;

        while (!gameOver) {
            printBoard(gameBoard);
            playerMove(gameBoard, currentPlayer);
            gameOver = isGameOver(gameBoard);
            if (gameOver) {
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        printBoard(gameBoard);
    }
}
