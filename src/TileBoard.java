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

	public TileBoard(Integer[][] board){
      myBoard = board;
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

	/*
	 * Returns the number of moves from the initial board
	 */
	public int getNumMoves(TileBoard b){
		return b.moves.size();
	}

/*	public static Integer[] seekAndDestroyMotherfucker(){
		Integer [] smallest = new Integer[2];
		for (int i = smallest[0]; i < 3; i++){
			for(int j = smallest[1]; j < 3; j++) {
    		  if (i-myBoard[i][j]/3 + j-myBoard[i][j]%3 == 0){
    			  return smallest;
    		  }
			}
		}
		
		return new Integer({-1});
	}
	*/
	/*
	 * Evaluates the given board using the Manhattan distance heuristic.
	 */
	public int calcManhattanDistance(TileBoard b){
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
	
	public List<Move> getMoves(){
		return moves;
	}

}
