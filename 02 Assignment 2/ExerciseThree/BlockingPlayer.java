import java.io.IOException;

public class BlockingPlayer extends RandomPlayer{

	public BlockingPlayer(String n, char m) {
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
		
		int i = 0;
		int j = 0;
		boolean blockable = false;
		
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				if (testForBlocking(i, j)) {
					blockable = true;
					break;		
				}
				if (blockable == true) {
					break;
				}
			}
			if (blockable == true) {
				break;
			}
		}
		
		int row = 0;
        int col = 0;
		
		if (blockable) {
			row = i;
	        col = j;
		}
		else {
    		row = RandomGenerator.discrete(0, 2);
            col = RandomGenerator.discrete(0, 2);
		}
        
        while (board.getMark(row, col) != SPACE_CHAR) {
    		row = RandomGenerator.discrete(0, 2);
            col = RandomGenerator.discrete(0, 2);
        }
        
        board.addMark(row, col, mark);
	}
	
	public boolean testForBlocking(int row, int col) {
		int count = 0;
		if (board.getMark(row, col) == SPACE_CHAR) {
			for (int i = 0; i < 3 && i != col; i++) {
				if (board.getMark(row, i) == opponent.mark) {
					count++;
				}
			}
			if (count == 2) {
				return true;
			}
			
//			count = 0;
//			for (int i = 0; i < 3 && i != row; i++) {
//				if (board.getMark(i, col) == opponent.mark) {
//					count++;
//				}
//			if (count == 2) {
//				return true;
//			}
//			}
//			
//			count = 0;
//			
//			if (col == row) {
//				for (int i = -2; i < 3; i++) {
//					if (col - i > -1 && col + i < 3) {
//						if (col + i > -1 && col - i < 3) {
//							if (board.getMark(col - i, row - i) == opponent.mark) {
//								count++;
//							}
//							if (board.getMark(col + i, row + i) == opponent.mark) {
//								count++;
//							}
//						}
//					}
//				}
//			}
//			
//			if (count == 2) {
//				return true;
//			}
		}
		return false;
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
