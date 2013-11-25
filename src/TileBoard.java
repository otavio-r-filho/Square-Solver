/******************************************************************************
 *
 *    Representation of a board and the sequence of moves that generated it
 *
 *
 * @author
 * @date
 *****************************************************************************/


import java.util.*;

public class TileBoard{

	//String representation of a puzzle board
	private Integer [][] myBoard = new Integer [3][3];
	//String representation of the list of moves that generated this board
	private List<Move> moves = new ArrayList<Move>();
	
	private int g;
	private int f;

	public TileBoard(Integer[][] board, int g){
      myBoard = board;
      this.g = g;
      this.f = this.calcManhattanDistance() + g;
	}
	
	public int getG(){
		return g;
	}
	
	public int getF(){
		return f;
	}
	
	public void setG(int g){
		this.g = g;
	}

	public void setF(int f){
		this.f = f;
	}
	
	/* Returns the position of a number on the board */
	public Integer[] seekNumber(int number){
		Integer [] position = new Integer[2];
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				if (myBoard[i][j] == number){
					position[0] = i;
					position[j] = j;
				}
			}
		}
		return position;
	}

	/* Returns the number of moves from the initial board */
	public int getNumMoves(){
		return moves.size();
	}

	/* Evaluates the given board using the Manhattan distance heuristic */
	public int calcManhattanDistance(){
		Integer distance = 0;
		for (int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
    		  Integer goalI = myBoard[i][j]/3;
    		  Integer goalJ = myBoard[i][j]%3;
    		  distance += i-goalI + j-goalJ;
			}
		}

		return distance;
	}
	
	/* Returns the last move of the move list */
	public Move getLastMove(){
		return moves.get(moves.size());
	}
	
	/* Move the empty tile to the desired position */
	public TileBoard moveTile(int direction){
		int i, j;

		// Get the position of the empty tile
		Integer[] emptyTilePos = seekNumber(0);

		// Set new empty tile coordinates based on movement direction
		switch (direction){
		case Move.LEFT:
			i = emptyTilePos[0];
			j = emptyTilePos[1]-1;
			break;
		case Move.UP:
			i = emptyTilePos[0]-1;
			j = emptyTilePos[1];
			break;
		case Move.RIGHT:
			i = emptyTilePos[0];
			j = emptyTilePos[1]+1;
			break;
		default:
			i = emptyTilePos[0]+1;
			j = emptyTilePos[1];
			break;
		}
		
		// If invalid position, return null
		if ((i < 0)||(i > 2)||(j < 0)||(j > 2)){
			return null;
		}

		// Create new board with moved tile
		Integer[][] newBoard = myBoard;
		newBoard[emptyTilePos[0]][emptyTilePos[1]] = newBoard[i][j];
		newBoard[i][j] = 0;
		return new TileBoard(newBoard, g+1);
	}
	
	public List<Move> getMoves(){
		return moves;
	}
	
	public Integer[][] getBoardMatrix(){
		return myBoard;
	}
	
	/*
	 * Returns a list of boards that are one move away.  This list *DOES NOT* contain the
	 * previous board, as this would undo a movement we've just made.
	 */
	public List<TileBoard> getNextBoards(){
		List<TileBoard> boardList = new ArrayList<TileBoard>();
		int oppositeMove = this.getLastMove().getOppositeDirection();
		
		// Find and add all possible movements
		TileBoard newBoard;
		if (oppositeMove != Move.UP){
			newBoard = this.moveTile(Move.UP);
			if (newBoard != null){
				boardList.add(newBoard);
			}
		}
		if (oppositeMove != Move.DOWN){
			newBoard = this.moveTile(Move.DOWN);
			if (newBoard != null){
				boardList.add(newBoard);
			}
		}
		if (oppositeMove != Move.LEFT){
			newBoard = this.moveTile(Move.LEFT);
			if (newBoard != null){
				boardList.add(newBoard);
			}
		}
		if (oppositeMove != Move.RIGHT){
			newBoard = this.moveTile(Move.RIGHT);
			if (newBoard != null){
				boardList.add(newBoard);
			}
		}
		
		return boardList;
	}
}
