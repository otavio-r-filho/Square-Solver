/*
	Os métodos desta classe são todos estáticos por que ela serve 
	somente para retornar direções, não é necessário criar um objeto
	para instanciá-la.
	
	Uma abstração que pode ser feita é que o tabuleiro pode mover-se somente
	de um jeito durante o tempo.
 */
public class Move{
	public static final int LEFT = 0;
	public static final int UP = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;

	private static int direction;
	private static int oppositeDirection;

	public Move(int dir){
		direction = dir;
		oppositeDirection = (direction + 2)%4;
	}
	
	public static int getDirection(){
		return direction;
	}
	
	public static int getOppositeDirection(){
		return oppositeDirection;
	}
}
