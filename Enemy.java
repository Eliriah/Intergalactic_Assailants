import java.awt.Rectangle;

public class Enemy extends Player{

	private boolean enemyMovementRight;

	public Enemy(int x,int y){
		super(x, y);
		this.enemyMovementRight = true;
	}
	public boolean getEnemyMovementRight(){
		return enemyMovementRight;
	}
	public void setEnemyMovementRight(boolean state){
		enemyMovementRight = state;
	}
	public Rectangle getEnemyBoundary(){
		return new Rectangle(getX_Coordinate(), getY_Coordinate(), getWidth(), getHeight());
	}
	public void enemyMovement(){
		if (getEnemyMovementRight() == true){
			if(getX_Coordinate() == (900)) {
				moveDown(5);
				setEnemyMovementRight(false);
			}
			else{
				moveRight();
			}
		}
		else{
			if(getX_Coordinate() == 0){
					moveDown(5);
					setEnemyMovementRight(true);
			}
			else{
				moveLeft();
			}
		}
	}
}
