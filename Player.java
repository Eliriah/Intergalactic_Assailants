import java.awt.Rectangle;

public class Player{

	private int x_coordinate;
	private int y_coordinate;
	private int width;
	private int height;

	public Player(int x,int y){
		this.x_coordinate = x;
		this.y_coordinate = y;
		this.width = 5;
		this.height = 5;
	}
	public int getX_Coordinate(){
		return x_coordinate;
	}
	public int getY_Coordinate(){
		return y_coordinate;
	}
	public void moveRight(){
		x_coordinate += 5;
	}
	public void moveleft(){
		x_coordinate -= 5;
	}
	public Rectangle getPlayerBoundry(){
		return new Rectangle(x_coordinate, y_coordinate, width, height);
	}
}