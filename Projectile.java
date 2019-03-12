import java.awt.Rectangle;

public class Projectile extends Player {
//instance variable
  private boolean projectileMovementUp;

  /**
  * Constructor that takes in the coordinates and dimensions as well as the state of the player
  * @param x
  * @param y
  * @param w
  * @param h
  * @param state  
  */

  public Projectile(int x, int y, int w, int h, boolean state) {
    super(x, y, w, h);
    this.projectileMovementUp = state;
  }
  /**
   * Getter that returns whether or not the projectile should move up
   * @return
   */
  public boolean getProjectileMovementUp(){
    return projectileMovementUp;
  }
  /**
   * Returns the boundary of the projectile's rectangle
   * @return
   */
  public Rectangle getProjectileBoundary(){
    return new Rectangle(getX_Coordinate(), getY_Coordinate(), getWidth(), getHeight());
  }
  /**
   * Sets how the projectile will move
   */
  public void projectileMovement() {
    if (projectileMovementUp == true)
      moveUp(10);
    if (projectileMovementUp == false)
      moveDown(10);
  }
}
