/**
 ******************************************************************************
 *                    HOMEWORK: 15-121
 ******************************************************************************
 *                    Sliding Tile Puzzle
 ******************************************************************************
 *
 *             Solves a 3x3 sliding tile puzzle
 *
 *
 * @author
 * @date
 *****************************************************************************/


import java.util.*;

public class SlidingSolver
{

	//Maximum search depth for BFS
	private static final int MAX_BFS_DISTANCE = 20;

	/* You may add instance and class variables and methods as you see fit */


	/*
	 * Constructs a SlidingSolver with the given input board.
	 */
	public SlidingSolver(String initialBoard)
	{
		/* Your code here */
	}

	/*
	 * Solves the puzzle by performing a breadth-first search over the puzzle space.
	 * Returns SlidingSolution.NO_SOLUTION if the maximum BFS search depth is reached.
	 */
	public SlidingSolution solvePuzzleBFS()
	{
		/* Your code here */
		return SlidingSolution.NO_RESPONSE;
	}

	/*
	 * Solves the puzzle by performing an A* search over the puzzle space.
	 */
	public SlidingSolution solvePuzzleAStar()
	{
		/* Your code here */
		return SlidingSolution.NO_RESPONSE;
	}

	/*
	 * Requirement #2
	 * Solves the puzzle by performing an breadth-first search over the puzzle space using the optimization described in "requirement #2".
	 */
	public SlidingSolution solvePuzzleBFSOptimized()
	{
		/* Your code here */
		return SlidingSolution.NO_RESPONSE;
	}

	/*
	 * Requirement #2
	 * Solves the puzzle by performing an A* search over the puzzle space using the optimization described in "requirement #2".
	 */
	public SlidingSolution solvePuzzleAStarOptimized()
	{
		/* Your code here */
		return SlidingSolution.NO_RESPONSE;
	}

	/*
	 * Evaluates the given board.
	 */
	private int evaluateHeuristic(TileBoard p)
	{
		return TileBoard.getNumMoves(b) + TileBoard.calcManhattanDistance(b);
	}

	class TileBoardComparator implements Comparator<TileBoard>
	{
		public int compare(TileBoard a, TileBoard b)
		{
			/* Your code here */
			return 0;
		}
	}


}
