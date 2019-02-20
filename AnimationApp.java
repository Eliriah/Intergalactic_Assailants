import java.util.scanner;
public class AnimationApp{
    private Player player;
    private ArrayList<Obstacle> obstacles;

    /*public void printCurrentState(){
        


    }*/

    public static void main(String[] args) {
        System.out.println("Press the 'a' key to move left. Press the 'd' key to move right. Press the spacebar to shoot.");
        Scanner keyboard = new Scanner(System.in);
        String keyEntered = keyboard.nextLine();
        if (keyEntered == 'a'){
            if(overlapsWith){
                System.out.println("Sorry, you can't move any farther left.");
            }
            else{
            //move avatar's x coordinate -1 
            System.out.println(/*new coordinate*/);
            }

        }
        if(keyEntered == 'd'){
            if(overlapsWith){
                System.out.println("Sorry, you can't move any farther right.");
            }
            else{
            //move avatar's x coordinate +1
            System.out.println(/*new coordinate*/);
            }


        }
        if (keyEntered == ' '){
            //shoot projectile up (y coordi +1) until it hits bound or collides with an enemy.
            System.out.println(/*new coordinates*/);
        }
        
    }
}