import java.util.Scanner;
public class AnimationApp{
    public static void main(String[] args) {
        System.out.println("Press the 'a' key to move left. Press the 'd' key to move right. Press the spacebar to shoot.");
        Scanner keyboard = new Scanner(System.in);
        char keyEntered = keyboard.next().charAt(0);
        Player player1 = new Player(0,0);
        
        if (keyEntered == 'a'){
            /*if(overlapsWith){
                System.out.println("Sorry, you can't move any farther left.");
            }*/
            player1.moveLeft();
            System.out.println(player1.getX_Coordinate());
        }

        if(keyEntered == 'd'){
            /*if(overlapsWith){
                System.out.println("Sorry, you can't move any farther right.");
            }*/
            player1.moveRight();
            System.out.println(player1.getX_Coordinate());
        }
    }
}