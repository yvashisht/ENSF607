import java.io.*;

/**
 * A class to represent the individual players of the game and their moves
 * 
 * @author Momin Muhammad
 */
abstract public class Player {
	/**
	 * Name of the player
	 */
	protected String name;
	/**
	 * A board variable to point to the board
	 */
	protected Board board;
	/**
	 * opponent of the player
	 */
	protected Player opponent;
	/**
	 * the mark of the player
	 */
	protected char mark;
	
	/** 
	 * constructor of the player
	 * @param n name of the player
	 * @param m mark of the player
	 */
	protected Player(String n, char m){
		name = n;
		mark = m;
	}
	
	/**
	 * Calls makeMove until the game is over
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void play() throws NumberFormatException, IOException {
        while (!board.isFull() && !board.xWins() && !board.oWins()) {
            makeMove();
            board.display();

            if (board.xWins()) {
            	System.out.println("THE GAME IS OVER: " + name + " is the winner!\r\n");
        		System.out.println("Game Ended ...");
            } else if (board.oWins()) {
            	System.out.println("THE GAME IS OVER: " + name + " is the winner!\r\n");
        		System.out.println("Game Ended ...");
            } else if (board.isFull()) {
            	System.out.println("THE GAME IS OVER: It's a tie");
        		System.out.println("Game Ended ...");
            }
            
            opponent.play();
        }
	}
	
	/**
	 * Places a mark at the designated location by prompting the player
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void makeMove() throws NumberFormatException, IOException {
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));

        // Print the messages
        System.out.print(name + ", what row should your next X be placed in? ");
        int row = Integer.parseInt(stdin.readLine());

        System.out.print(name + ", what column should your next X be placed in? ");
        int col = Integer.parseInt(stdin.readLine());
        
		board.addMark(row, col, mark);
	}
	
	/**
	 * sets the opponent
	 * @param opp the opponent
	 */
	public void setOpponent(Player opp) {
		this.opponent = opp;
	}
	
	/**
	 * sets theBoard
	 * @param theBoard
	 */
	public void setBoard(Board theBoard) {
		this.board = theBoard;
	}
}
