import java.util.*;

public class SlidingSolver{
	private static int maxDepth = 26;
	private static List<TileBoard> closedList;
	private static List<TileBoard> openList;

	public SlidingSolver(){
		// Initialize queues
		closedList = new ArrayList<TileBoard>();
		openList = new ArrayList<TileBoard>();
		Integer[][] initialBoardMatrix = new Integer[][]{{1, 2, 3}, {4, 0, 5}, {7, 8, 6}};
		openList.add(new TileBoard(initialBoardMatrix, 0));
		
		// Print initial board
		System.out.println("The initial board is:");
		int i, j;
		for (i = 0; i < 3; i++){
			for (j = 0; j < 2; j++){
				System.out.print(initialBoardMatrix[i][j] + "|");
			}
			System.out.println(initialBoardMatrix[i][j]);
		}
		
		// Solve board
		solveAStar();
	}

	/* Solves the puzzle by performing an A* search over the puzzle space */
	public void solveAStar(){
		TileBoard finalBoard = null;

		while (!openList.isEmpty()&&(finalBoard == null)){
			// Get next board to be analyzed
			TileBoard currentBoard = getSmallestCostBoard();
			closedList.add(currentBoard);
			
			// Check if reached goal state
			if (currentBoard.calcManhattanDistance() == 0){
				finalBoard = currentBoard;
			}

			// Check all neighbors
			List<TileBoard> neighbors = currentBoard.getNextBoards();
			for (int i = 0; i < neighbors.size(); i++){
				TileBoard neighbor = neighbors.get(i);
				
				// Check if neighbor is in closedList
				if (searchBoard(neighbor, 1) >= 0){
					continue;
				}
				
				// If not explored yet, check if neighbor is in openList
				int boardPosition = searchBoard(neighbor, 0);
				// If it's not in openList, add it to it
				if (boardPosition == -1){
					openList.add(neighbor);
				}
				else{
					// Else, check if it's F is smaller than the previous one
					if (neighbor.getF() < openList.get(boardPosition).getF()){
						// If so, update F
						openList.get(boardPosition).setG(neighbor.getG());
						openList.get(boardPosition).setF(neighbor.getF());
					}
				}
			}
		}
		
		if (finalBoard == null){
			showSolution(finalBoard.getMoves());
		}
		else{
			System.out.println("Couldn't find final state");
		}
	}
	
	public int searchBoard(TileBoard searched, int listNum){
		if (listNum == 0){
			for (int i = 0; i < openList.size(); i++){
				if (equalBoards(openList.get(i), searched) == 1){
					return i;
				}
			}
		}
		else{
			for (int i = 0; i < closedList.size(); i++){
				if (equalBoards(closedList.get(i), searched) == 1){
					return i;
				}
			}
		}
		
		return -1;
	}
	
	public TileBoard getSmallestCostBoard(){
		int smallestI = 0;
		for (int i = 0; i < openList.size(); i++){
			if (openList.get(i).calcManhattanDistance() < openList.get(smallestI).calcManhattanDistance()){
				smallestI = i;
			}
		}
		return openList.remove(smallestI);
	}

	private void showSolution(List<Move> moveList){
		System.out.println("Moves needed to solve board:");
		for (int i = 0; i < moveList.size(); i++){
			System.out.print(moveList.get(i) + " ");
		}
		System.out.println();
	}

	public int equalBoards(TileBoard a, TileBoard b){
		Integer[][] aMatrix = a.getBoardMatrix();
		Integer[][] bMatrix = b.getBoardMatrix();
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if (aMatrix[i][j] != bMatrix[i][j]){
					return 0;
				}
			}
		}
		return 1;
	}
}
