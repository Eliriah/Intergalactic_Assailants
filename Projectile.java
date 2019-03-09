import java.awt.Rectangle;

public class Projectile extends Player {
  /**
   * Movement up for player projectile (true)
   * Movement down for projectile projectile (false)
   */
  private boolean projectileMovementUp;

  public Projectile(int x, int y, boolean state) {
    super(x, y);
    this.projectileMovementUp = state;
  }
  /**
   * Getter method that returns a boolean value of whether or not the projectile should move right
   * @return
   */
  public boolean getProjectileMovementUp(){
    return projectileMovementUp;
  }
  /**
   * Setter method that sets the projectile's state
   */
  public void setLive(boolean state){
    setLive(state);
  }
  /**
   * Getter method that returns rectangle of the projectile's current position.
   */
  public Rectangle getProjectileBoundary(){
    return new Rectangle(getX_Coordinate(), getY_Coordinate(), getWidth(), getHeight());
  }
}
