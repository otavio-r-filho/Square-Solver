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
		String puzzle = "123405786";
		SlidingSolution solution = new SlidingSolver(puzzle).solvePuzzleBFS();
		System.out.println(solution.getMoves());
	}

}








