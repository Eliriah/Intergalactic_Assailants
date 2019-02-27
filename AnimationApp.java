import java.util.Scanner;
import java.awt.Rectangle;

public class AnimationApp{
	/**
	 * Method that controls how the enemy moves.
	 * The enemy is set to move in a specific pattern.
	 * The enemy will move to the right until it hits an x coordinate of 40.
	 * Afterwards, it will move down and then to the left, continuing this pattern until it collides with the player.
	 * The enemy's coordinates will print out after each user input.
	 * @param enemy
	 */
    public static void enemyMovement(Enemy enemy){

		if (enemy.getEnemyMovementRight() == true){

			if(enemy.getX_Coordinate() == (40)) {
				//if the enemy is against the right wall, it will move down and move left
				enemy.moveDown();
				enemy.setEnemyMovementRight(false);
				System.out.println("Enemy position : " +enemy.getX_Coordinate() + " " + enemy.getY_Coordinate());
			}

			else{
				enemy.moveRight();
				System.out.println("Enemy position : " +enemy.getX_Coordinate() + " " + enemy.getY_Coordinate());
			}
		}

		else{
			if(enemy.getX_Coordinate() == (-40)){
				//if the enemy is against the left wall, it will move down and move right
					enemy.moveDown();
					enemy.setEnemyMovementRight(true);
					System.out.println("Enemy position : " +enemy.getX_Coordinate() + " " + enemy.getY_Coordinate());
			}
			else{
				enemy.moveLeft();
				System.out.println("Enemy position : " +enemy.getX_Coordinate() + " " + enemy.getY_Coordinate());
			}
		}
	}
	/**
	 * Method that detects when the player and the enemy's rectangles have intersected, causing the game to end.
	 * @param player
	 * @param enemy
	 */
	public static boolean collisionDetection(Player player, Enemy enemy){
		boolean collision = false;
		Rectangle r1 = player.getPlayerBoundary();
		Rectangle r2 = enemy.getEnemyBoundary();

		if (r1.intersects(r2))
			collision = true;
		return collision;
	}
	public static void main(String[] args){

		Player player1 = new Player(0,0);
		Enemy enemy1 = new Enemy(-40,25);
		boolean enemy_movement_right = true;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Player Position: "+player1.getX_Coordinate()+", "+player1.getY_Coordinate());
		System.out.println("Enemy position : " +enemy1.getX_Coordinate() + ", " + enemy1.getY_Coordinate());

		while (player1.getLive() == true){

			System.out.println("Press the 'a' key to move left. Press the 'd' key to move right.");
			char keyEntered = keyboard.next().charAt(0);

			if (keyEntered == 'a'){

				if(player1.getX_Coordinate() == (-50)){
					//sets a limit to how far the player can move left
					System.out.println("Sorry, you can't move any farther left.");
          System.out.println("Player Position: "+player1.getX_Coordinate()+", "+player1.getY_Coordinate());
				}

				else{

					player1.moveLeft();
					System.out.println("Player Position: "+player1.getX_Coordinate()+", "+player1.getY_Coordinate());

				}

			}
			if(keyEntered == 'd'){

				if(player1.getX_Coordinate() == 50){
					//sets a limit to how far the player can move right.
					System.out.println("Sorry, you can't move any farther right.");
          System.out.println("Player Position: "+player1.getX_Coordinate()+", "+player1.getY_Coordinate());
				}

				else{
					player1.moveRight();
					System.out.println("Player Position: "+player1.getX_Coordinate()+", "+player1.getY_Coordinate());
				}

			}
			enemyMovement(enemy1);

			if (collisionDetection(player1, enemy1) == true){
			// the game's end condition where the enemy and the player collide.
				player1.setLive(false);
				System.out.println("GAME OVER");
      }
      if ((enemy1.getY_Coordinate() == 0) && (enemy1.getX_Coordinate() == -40)) {
        player1.setLive(false);
        System.out.println("GAME OVER");
			}
		}
	}
}
