import java.util.Scanner;
import java.awt.Rectangle;

public class AnimationApp{
    public static void main(String[] args) {
        System.out.println("Press the 'a' key to move left. Press the 'd' key to move right. Press the spacebar to shoot.");
        Player player1 = new Player(0,0);
        Enemy enemy1 = new Enemy(-40,22);
        boolean enemy_movement_right = true;
        while(player1.getLive() == true){
            Scanner keyboard = new Scanner(System.in);
            char keyEntered = keyboard.next().charAt(0);
            if (keyEntered == 'a'){
                if(player1.getX_Coordinate() == (-50)){
                    System.out.println("Sorry, you can't move any farther left.");
                }
                else{
                    player1.moveLeft();
                    System.out.println(player1.getX_Coordinate());
                    Rectangle r1 = player1.getPlayerBoundary();
                    Rectangle r2 = enemy1.getEnemyBoundary();
                    if (r1.intersects(r2)){
                        player1.setLive(false);
                        System.out.println("GAME OVER");
                    }
                }
            }
            if(keyEntered == 'd'){
                if(player1.getX_Coordinate() == 50){
                    System.out.println("Sorry, you can't move any farther right.");
                }
                else{
                    player1.moveRight();
                    System.out.println(player1.getX_Coordinate());
                    }
                }

                if(keyEntered=='a' || keyEntered=='d') {
                    if(enemy_movement_right==true) {
    
    
                        if(enemy1.getX_Coordinate() == (40)) {
                            enemy1.moveDown();
                            enemy_movement_right=false;
                            System.out.println("Enemy position : " +enemy1.getX_Coordinate() + " " + enemy1.getY_Coordinate());
                        }
                        else {
                            enemy1.moveRight();
                            System.out.println("Enemy position : " +enemy1.getX_Coordinate() + " "+enemy1.getY_Coordinate());
                        }
                    }
                    else{
    
                        if(enemy1.getX_Coordinate() == (-40)){
                            enemy1.moveDown();
                            enemy_movement_right=true;
                            System.out.println("Enemy position : " +enemy1.getX_Coordinate() + " " + enemy1.getY_Coordinate());
                        }
                        else {
                            enemy1.moveLeft();
                            System.out.println("Enemy position : " +enemy1.getX_Coordinate() + " " + enemy1.getY_Coordinate());
                        }
                    }
                }
    
            }
    
        }
    }