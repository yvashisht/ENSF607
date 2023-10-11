import java.io.IOException;

/**
 * A class to set the opponents of both players in the game and start the game
 * 
 * @author Momin Muhammad
 */
public class Referee {
	/**
	 * A player variable to point to the player whose mark is X
	 */
	private Player xPlayer;
	/**
	 * A player variable to point to the player whose mark is O
	 */
	private Player oPlayer;
	/**
	 * A Board variable to point to a Board object
	 */
	private Board board;
	
	/**
	 * A method that sets the opponents for both players and starts the game
	 * at player X's turn
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void runTheGame() throws NumberFormatException, IOException {
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();
	}
	
	/**
	 * sets the board variable
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * sets player O
	 * @param oPlayer
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	
	/**
	 * sets player X
	 * @param xPlayer
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
}
