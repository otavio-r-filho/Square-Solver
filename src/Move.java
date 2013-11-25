import java.util.ArrayList;
import java.util.List;

public class Move{
	public static final int LEFT = 0;
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;

	private int direction;
	private int oppositDirection;

	public Move(int dir){
		direction = dir;
		oppositDirection = (direction + 2)%4;
	}
	
	public int getDirection(){
		return direction;
	}
	
	public int getOppositDirection(){
		return oppositDirection;
	}
	
	/*
	 * Returns a list of boards that are one move away.  This list *DOES NOT* contain the
	 * previous board, as this would undo a moving we've just made.
	 */
	public List<TileBoard> getNextBoards(TileBoard b){
		List boardList = new ArrayList<TileBoard>();
		int oppositMove = b.moves.get(moves.size()).getOppositDirection();
		
		// Seek empty tile
		Integer [] position = seekNumber(0);
		
		// Find all possible movements
		if (position[0] - 1 >= 0){
			if (oppositMove != Move.UP){
				
				boardList.add();
			}
		}
		if (position[0] + 1 < 3){
			if (oppositMove != Move.DOWN){
				
			}
		}
		if (position[1] - 1 >= 0){
			if (oppositMove != Move.LEFT){
				
			}
		}
		if (position[1] + 1 < 3){
			if (oppositMove != Move.RIGHT){
				
			}
		}
		
		return null;
	}
}