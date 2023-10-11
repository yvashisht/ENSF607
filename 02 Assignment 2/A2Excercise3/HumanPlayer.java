import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{

	public HumanPlayer(String n, char m) {
		super(n, m);
		// TODO Auto-generated constructor stub
	}
	
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
        System.out.print(name + ", what row should your next " + mark + " be placed in? ");
        int row = Integer.parseInt(stdin.readLine());

        System.out.print(name + ", what column should your next " + mark + " be placed in? ");
        int col = Integer.parseInt(stdin.readLine());
        
		board.addMark(row, col, mark);
	}

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
