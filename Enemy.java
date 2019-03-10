import java.awt.Rectangle;

public class Enemy extends Player{

	private boolean enemyMovementRight;

	public Enemy(int x,int y, int h, int w){
		super(x, y, h, w);
		this.enemyMovementRight = true;
	}
	public Enemy(int x,int y){
		super(x, y, 5, 5);
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
        
	public void enemyMovement(Player a){
            boolean ifPlayerCanMove;
		if (getEnemyMovementRight() == true){
			if(getX_Coordinate() == (900)) {
                            if(getY_Coordinate()<800)
				moveDown();
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