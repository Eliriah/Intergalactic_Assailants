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
	 * Constructor that takes in coordinates, the dimensions of the player and the state of tha player
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */

	public Player(int x,int y, int w, int h){
		this.x_coordinate = x;
		this.y_coordinate = y;
		this.width = w;
		this.height = h;
		this.live = true;
	}
	/**
	 * Constructor that takes in the player's x and y coordinates
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
	//Getters
	/**
	 * Getter method that returns the X coordinate
	 * @return
	 */
	public int getX_Coordinate(){
		return x_coordinate;
	}
	/**
	 * Getter method that returns the Y coordinate
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
	 * Getter method that returns the width
	 * @return
	 */
	public int getWidth(){
		return width;
	}
	/**
	 * Getter method that returns the height
	 * @return
	 */
	public int getHeight(){
		return height;
	}
	/**
	 * Moves the player 5 coordinates to the right
	 */
	public void moveRight(){
		x_coordinate += 5;
	}
	/**
	 * Moves the player 5 coordinates to the left
	 */
	public void moveLeft(){
		x_coordinate -= 5;
	}
	//Setters
	/**
	 * Setter that sets the X coordinate
	 * @param a
	 */
        public void setXCoordinate(int a){
            x_coordinate = a;
		}
		/**
		 * Setter that sets the Y coordinate
		 * @param a
		 */
        public void setYCoordinate(int a){
            y_coordinate = a;
		}
	/**
	 * Setter that sets the life of the player
	 * @param state
	 */
	public void setLive(boolean state){
			if (live != state)
            	live = state;
	}
	/**
	 * Sets the width of the player
	 * @param aWidth
	 */
	public void setWidth(int aWidth){
		width = aWidth;
	}
	/**
	 * Sets the height of the player
	 * @param aHeight
	 */
	public void setHeight(int aHeight){
		height = aHeight;
	}
	/**
	 * Moves player down 50 coordinates
	 */
	public void moveDown() {
            y_coordinate += 50;
	}
	/**
	 * Moves the player down a set distance
	 * @param distance
	 */
        public void moveDown(int distance){
            y_coordinate+=distance;
		}
		/**
		 * Moves the player up a set distance
		 * @param distance
		 */
        public void moveUp(int distance){
            y_coordinate-=distance;
		}
		/**
		 * Returns the rectangle which the player resides in
		 * @return
		 */
	public Rectangle getPlayerBoundary(){
		return new Rectangle(x_coordinate, y_coordinate, width, height);
	}
}