public class Projectile extends Player {
    // Instance Variable
    private boolean projectileMovingUp;

    // Consturctor
    public Projectile(int x, int y, int w, int h, boolean state) {
        super(x, y, w, h);
        this.projectileMovingUp = state;
    }

    // Getter
    public boolean getProjectileMovingUp() {
        return projectileMovingUp;
    }

    // Movement
    public void projectileMoving(int speed) {
        if (projectileMovingUp == true)
            moveUp(speed);
        if (projectileMovingUp == false)
            moveDown(speed);
    }
}