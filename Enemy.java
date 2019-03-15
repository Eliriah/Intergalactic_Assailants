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
    public void enemyMovement(Player player) {
        if (getEnemyMovementRight() == true) {
            if (getX_Coordinate() == (900)) {
                if (getY_Coordinate() < 800)
                    moveDown(50);
                setEnemyMovementRight(false);
            } else {
                if (getX_Coordinate() != player.getX_Coordinate() - 50 || getY_Coordinate() < 800)
                    moveRight(5);
                else {
                    player.setLive(false);
                }
            }
        } else {
            if (getX_Coordinate() == 0) {
                if (getY_Coordinate() < 800)
                    moveDown(50);
                setEnemyMovementRight(true);
            } else {
                if (getX_Coordinate() != player.getX_Coordinate() + 50 || getY_Coordinate() < 800)
                    moveLeft(5);
                else {
                    player.setLive(false);
                }
            }
        }
    }
}