import java.io.*;
import java.util.Scanner;

// STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS

public class Game implements Constants {

    private Board theBoard;
    private Referee theRef;

    public Game() {
        theBoard = new Board();
    }

    public void appointReferee(Referee r) throws IOException {
        theRef = r;
        theRef.runTheGame();
    }
    
    /**
     * The Referee class sets up the board and manages the game between two players.
     */

    public static class Referee {

        private Board board;
        private Player xPlayer;
        private Player oPlayer;
        
        /**
         * Sets the game board.
         *
         * @param board The game board to set.
         */

        public void setBoard(Board board) {
            this.board = board;
        }
        
        /**
         * Sets the player who plays with 'X'.
         *
         * @param xPlayer The player who plays with 'X'.
         */
        
        public void setxPlayer(Player xPlayer) {
            this.xPlayer = xPlayer;
        }

        /**
         * Sets the player who plays with 'O'.
         *
         * @param oPlayer The player who plays with 'O'.
         */
        
        public void setoPlayer(Player oPlayer) {
            this.oPlayer = oPlayer;
        }

        /**
         * Runs the Tic Tac Toe game.
         */
        
        public void runTheGame() {

            Player currentPlayer = xPlayer;

            while (true) {
            	
                board.display();
                currentPlayer.makeMove();

                if (board.xWins()) {
                    board.display();
                    System.out.println("Player X wins!!");
                    break;
                } else if (board.oWins()) {
                    board.display();
                    System.out.println("Player O wins!!");
                    break;
                } else if (board.isFull()) {
                    board.display();
                    System.out.println("It's a tie!");
                    break;
                }
                
                if (currentPlayer == xPlayer) {
                	currentPlayer = oPlayer;
                } else {
                	currentPlayer = xPlayer;
                }
            }

        }
    }

    /**
     * The Player class represents a player in the Tic Tac Toe game.
     */
    
    public static class Player {

        private String name;
        private char mark;
        private Board board;
        
        /**
         * Constructs a new Player with the given name and mark ('X' or 'O').
         *
         * @param name The name of the player.
         * @param mark The player's mark ('X' or 'O').
         */

        public Player(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }

        /**
         * Sets the game board for the player.
         *
         * @param board The game board to set.
         */
        
        public void setBoard(Board board) {
            this.board = board;
        }

        /**
         * Allows the player to make a move in the game.
         *
         * @throws InputMismatchException If the input is not valid.
         */
        
        public void makeMove() {

            Scanner scanner = new Scanner(System.in);
            int row, col;

            while (true) {
                try {

                    System.out.println(name + ", enter the row for your move (0, 1, or 2): ");
                    row = scanner.nextInt();

                    System.out.println(name + ", enter the column for your move (0, 1, or 2): ");
                    col = scanner.nextInt();

                    if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.getMark(row, col) == Constants.SPACE_CHAR) {
                        board.addMark(row, col, mark);
                        break;
                    } else {
                        System.out.println("Invalid move. Try again!");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Try again!");
                    scanner.nextLine();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Referee theRef;
        Player xPlayer, oPlayer;
        BufferedReader stdin;
        Game theGame = new Game();
        stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nPlease enter the name of the \'X\' player: ");
        String name = stdin.readLine();
        while (name == null) {
            System.out.print("Please try again: ");
            name = stdin.readLine();
        }

        xPlayer = new Player(name, LETTER_X);
        xPlayer.setBoard(theGame.theBoard);

        System.out.print("\nPlease enter the name of the \'O\' player: ");
        name = stdin.readLine();
        while (name == null) {
            System.out.print("Please try again: ");
            name = stdin.readLine();
        }

        oPlayer = new Player(name, LETTER_O);
        oPlayer.setBoard(theGame.theBoard);

        theRef = new Referee();
        theRef.setBoard(theGame.theBoard);
        theRef.setoPlayer(oPlayer);
        theRef.setxPlayer(xPlayer);

        theGame.appointReferee(theRef);
    }
}



