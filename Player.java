import java.awt.Rectangle;

public class Player{
	/**
	 * Instance variables for this class.
	 */

	private int x_coordinate;
	private int y_coordinate;
	private int width;
	private int height;
	private boolean live;
	/**
	 * Constructor that takes in x and y as an argument
	 * @param x
	 * @param y
	 */

	public Player(int x,int y){
		this.x_coordinate = x;
		this.y_coordinate = y;
		this.width = 5;
		this.height = 5;
		this.live = true;
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
	 * Getter method that returns whether or not the player is alive
	 * @return
	 */
	public boolean getLive(){
		return live;
	}
	/**
	 * Setter method that sets the player's x coordinate 10 to the right
	 */
	public void moveRight(){
		x_coordinate += 10;
	}
	/**
	 * Setter method that sets the player's x coordinate 10 to the left.
	 */
	public void moveLeft(){
		x_coordinate -= 10;
	}
	/**
	 * Setter method that sets the players state
	 */
	public void setLive(boolean state){
		live = state;
	}
	/**
	 * Getter method that returns rectangle of the player's current position.
	 */
	public Rectangle getPlayerBoundary(){
		return new Rectangle(x_coordinate, y_coordinate, width, height);
	}
}