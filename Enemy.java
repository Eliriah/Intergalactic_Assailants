public class Enemy extends Player {
    // New instance variables
    private boolean enemyMovementRight;

    // Constructor
    public Enemy(int x, int y, int h, int w) {
        super(x, y, h, w);
        this.enemyMovementRight = true;
    }

    // Getter
    public boolean getEnemyMovementRight() {
        return enemyMovementRight;
    }

    // Setter
    public void setEnemyMovementRight(boolean state) {
        enemyMovementRight = state;
    }

    // Movement
    public void enemyMovement(int enemySpeed) {
        if (getEnemyMovementRight() == true){
            if (getX_Coordinate() >= 930){
                moveDown(50);
                setEnemyMovementRight(false);
            }
            moveRight(enemySpeed);
        }
        else {
            if (getX_Coordinate() <= 0){
                moveDown(50);
                setEnemyMovementRight(true);
            }
            moveLeft(enemySpeed);
        }
    }
}