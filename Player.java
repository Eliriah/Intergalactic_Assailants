import java.awt.Rectangle;

public class Player{

	private int x_coordinate;
	private int y_coordinate;
	private int width;
	private int height;
	private boolean live;

	//Constructor
	public Player(int x,int y){
		this.x_coordinate = x;
		this.y_coordinate = y;
		this.width = 5;
		this.height = 5;
		this.live = true;
	}
	//Getters
	public int getX_Coordinate(){
		return x_coordinate;
	}
	public int getY_Coordinate(){
		return y_coordinate;
	}
	public boolean getLive(){
		return live;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	//Setters
	public void setLive(boolean state){
		live = state;
	}
	public void moveDown(int distance){
		y_coordinate += distance;
	}
	public void moveUp(int distance){
		y_coordinate -= distance;
	}
	public void moveRight(){
		x_coordinate += 5;
	}
	public void moveLeft(){
		x_coordinate -= 5;
	}
	//methods
	public Rectangle getPlayerBoundary(){
		return new Rectangle(x_coordinate, y_coordinate, width, height);
	}
}
