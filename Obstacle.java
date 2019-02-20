public class Obstacle {
	String name;
	int x,y;
	Player a;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean overlapsWith() {
		if(this.getX()==a.getX_Coordinate() && this.getY()==a.getY_Coordinate()) {
			return true;
		}
		else {
			return false;
		}
	}
}