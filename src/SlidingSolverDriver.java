/**
 ******************************************************************************
 *                    HOMEWORK: 15-121
 ******************************************************************************
 *                    Sliding Tile Puzzle
 ******************************************************************************
 *
 *
 *
 *
 * @author  PLEASE PERFORM ADDITIONAL TESTING!!!
 * @date
 *****************************************************************************/

public class SlidingSolverDriver
{

	public static void main(String[] args)
	{
		Integer[][] puzzle = new Integer [][] {{1, 2, 3}, {4, 0, 5}, {7, 8, 6}};
		SlidingSolution solution = new SlidingSolver(puzzle).solvePuzzleBFS();
		System.out.println(solution.getMoves());
	}

}








