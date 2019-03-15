import java.awt.Rectangle;

public class Player {
    // The Players instance Variables
    private int x_coordinate;
    private int y_coordinate;
    private int width;
    private int height;
    private boolean live;

    // Player constructer
    public Player(int x, int y, int w, int h) {
        this.x_coordinate = x;
        this.y_coordinate = y;
        this.width = w;
        this.height = h;
        this.live = true;
    }

    // Getters
    public int getX_Coordinate() {
        return x_coordinate;
    }

    public int getY_Coordinate() {
        return y_coordinate;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean getLive() {
        return live;
    }

    // Setters
    public void setXCoordinate(int a) {
        x_coordinate = a;
    }

    public void setYCoordinate(int a) {
        y_coordinate = a;
    }

    public void setLive(boolean state) {
        if (live != state)
            live = state;
    }

    public void setWidth(int aWidth) {
        width = aWidth;
    }

    public void setHeight(int aHeight) {
        height = aHeight;
    }

    // Movement
    public void moveRight(int distance) {
        x_coordinate += distance;
    }

    public void moveLeft(int distance) {
        x_coordinate -= distance;
    }

    public void moveDown(int distance) {
        y_coordinate += distance;
    }

    public void moveUp(int distance) {
        y_coordinate -= distance;
    }

    // Hitbox
    public Rectangle getUnitHitBox() {
        return new Rectangle(x_coordinate, y_coordinate, width, height);
    }
}