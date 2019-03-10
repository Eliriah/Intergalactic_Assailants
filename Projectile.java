import java.awt.Rectangle;

public class Projectile extends Player {

  private boolean projectileMovementUp;

  public Projectile(int x, int y, int w, int h, boolean state) {
    super(x, y, w, h);
    this.projectileMovementUp = state;
  }
  
  public boolean getProjectileMovementUp(){
    return projectileMovementUp;
  }
  
  public Rectangle getProjectileBoundary(){
    return new Rectangle(getX_Coordinate(), getY_Coordinate(), getWidth(), getHeight());
  }
  public void projectileMovement() {
    if (projectileMovementUp == true)
      moveUp(10);
    if (projectileMovementUp == false)
      moveDown(10);
  }
}
