import java.awt.Rectangle;

public class Enemy {
	/**
	 * Instance variables for this class.
	 */
	private int x_coordinate;
	private int y_coordinate;
	private int width;
	private int height;
	private boolean live;
	private boolean enemyMovementRight;

	/**
	 * Constructor that takes in x and y as an argument
	 * @param x
	 * @param y
	 */

	public Enemy(int x,int y){
		this.x_coordinate = x;
		this.y_coordinate = y;
		this.width = 5;
		this.height = 5;
		this.live = true;
		this.enemyMovementRight = true;
	}
	/**
	 * Getter method that returns the value of x_coordinate
	 * @return
	 */
	public int getX_Coordinate(){
		return x_coordinate;
	}
		/**
	 * Getter method that returns the value of y_coordinate
	 * @return
	 */
	public int getY_Coordinate(){
		return y_coordinate;
	}
	/**
	 * Getter method that returns whether or not the enemy is alive
	 * @return
	 */
	public boolean getLive(){
		return live;
	}
	/**
	 * Getter method that returns a boolean value of whether or not the enemy should move right
	 * @return
	 */
	public boolean getEnemyMovementRight(){
		return enemyMovementRight;
	}
	/**
	 * Setter method that sets the enemy's x coordinate 10 to the right
	 */
	public void moveRight(){
		x_coordinate += 10;
	}
	/**
	 * Setter method that sets the enemy's x coordinate 10 to the left.
	 */
	public void moveLeft(){
		x_coordinate -= 10;
	}
	/**
	 * Setter method that sets the enemy's y coordinate down 5
	 */
	public void moveDown() {
		y_coordinate -= 5;
	}
	/**
	 * Setter method that sets the enemy's state
	 */
	public void setLive(boolean state){
		live = state;
	}
	/**
	 * Setter method that sets the enemy's right movement state
	 */
	public void setEnemyMovementRight(boolean state){
		enemyMovementRight = state;
	}
	/**
	 * Getter method that returns rectangle of the enemy's current position.
	 */
	public Rectangle getEnemyBoundary(){
		return new Rectangle(x_coordinate, y_coordinate, width, height);
	}
}
