import java.awt.Rectangle;

public class Enemy extends Player{

	//instance variable
	private boolean enemyMovementRight;

	/**
	 * Constructoe that takes in the coordinates and dimensions from the superclass
	 * @param x
	 * @param y
	 * @param h
	 * @param w
	 */
	public Enemy(int x,int y, int h, int w){
		super(x, y, h, w);
		this.enemyMovementRight = true;
	}
	/**
	 * Constructor that takes in just the coordinates
	 * @param x
	 * @param y
	 */
	public Enemy(int x,int y){
		super(x, y, 5, 5);
		this.enemyMovementRight = true;
	}
	/**
	 * Method that returns whether or not the enemy is supposed to move right
	 * @return
	 */
	public boolean getEnemyMovementRight(){
		return enemyMovementRight;
	}
	/**
	 * Method that sets whether or not the enemy moves right
	 * @param state
	 */
	public void setEnemyMovementRight(boolean state){
		enemyMovementRight = state;
	}
	/**
	 * Returns the boundaries of the enemy's rectangle
	 * @return
	 */
	public Rectangle getEnemyBoundary(){
		return new Rectangle(getX_Coordinate(), getY_Coordinate(), getWidth(), getHeight());
	}
        /**
		 * Sets how the enemy moves depending on the coordinates
		 * @param 2
		 */
	public void enemyMovement(Player a){
			boolean ifPlayerCanMove;
			//if the enemy is supposed to move right
		if (getEnemyMovementRight() == true){
			//if the enemy's coordinate is 900
			if(getX_Coordinate() == (900)) {
				//if the enemy's y coordinate is less than 800
							if(getY_Coordinate()<800)
				//the enemy will move down			
				moveDown();
				//the enemy will start to move left
				setEnemyMovementRight(false);
			}
			else{
                            if(getX_Coordinate() != a.getX_Coordinate()-50 || getY_Coordinate()<800)
				moveRight();
                            else{
                                ifPlayerCanMove=false;
                                Runner.setIfPlayerCanMove(ifPlayerCanMove);
                            }
			}
		}
		else{
			if(getX_Coordinate() == 0){
                            if(getY_Coordinate()<800)
                                moveDown();
                                setEnemyMovementRight(true);
			}
			else{
                            if(getX_Coordinate() != a.getX_Coordinate()+50 || getY_Coordinate()<800)
				moveLeft();
                            else{
                                ifPlayerCanMove=false;
                                Runner.setIfPlayerCanMove(ifPlayerCanMove);
                            }
			}
		}
	}
}