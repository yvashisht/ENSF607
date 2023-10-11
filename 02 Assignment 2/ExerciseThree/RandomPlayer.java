import java.io.IOException;

public class RandomPlayer extends Player implements Constants{

	public RandomPlayer(String n, char m) {
		super(n, m);
		// TODO Auto-generated constructor stub
	}
	
	public void play() throws NumberFormatException, IOException{
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
	public void makeMove(){ 
		int row = RandomGenerator.discrete(0, 2);
        int col = RandomGenerator.discrete(0, 2);
        
        while (board.getMark(row, col) != SPACE_CHAR) {
    		row = RandomGenerator.discrete(0, 2);
            col = RandomGenerator.discrete(0, 2);
        }
        
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
