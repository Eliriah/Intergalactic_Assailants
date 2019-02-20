import java.util.Scanner;
public class AnimationApp{
    public static void main(String[] args) {
        System.out.println("Press the 'a' key to move left. Press the 'd' key to move right. Press the spacebar to shoot.");
        Player player1 = new Player(0,0);
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

        }

    }
}