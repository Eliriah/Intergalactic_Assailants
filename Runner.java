import static javafx.application.Application.launch;
import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.*;
/**
 * Class that runs the game
 */

public class Runner extends Application{
// Instance Variables

    private Pane root = new Pane();
    private Scene scene = new Scene(root, 1000, 1000);
    private Player player = new Player(500, 800, 50, 50);
    private boolean movingRight, movingLeft, fireShot;

// R.N.G.

    private Random randomNumber = new Random();

// Arraylists

    private ArrayList<Projectile> bullets = new ArrayList<Projectile>();
    private ArrayList<ImageView> theBullets = new ArrayList<ImageView>();

    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private ArrayList<ImageView> theEnemies = new ArrayList<ImageView>();

    private ArrayList<Projectile> enemyBullets = new ArrayList<Projectile>();
    private ArrayList<ImageView> theEnemyBullets = new ArrayList<ImageView>();

// Used for Enemy movement

    static boolean ifPlayerCanMove = true;

    /**
     * Sets if the player can move or not
     * @param a
     */

    public static void setIfPlayerCanMove(boolean a){
        ifPlayerCanMove = a;
    }

// Methods for Spawning game elements 
/**
 * Spawns enemies onto the screen
 * @param numberOfEnemies
 */

    public void spawnEnemies(int numberOfEnemies){
        // Used to seperate Enemy Spawns
        int x = 0;
        int y = 0;
        for(int i = 0; i < numberOfEnemies; i++){
            // Checks if spawns have reached the outer limit of the game board
            if ((50 + (x * 100)) == 950){
                x = 0;
                y++;
            }
            Enemy enemy = new Enemy((50 + (x * 100)), (50 + (y * 50)), 50, 50);
            // Enemy moves left or right based on y value
            if (y%2 != 0)
                enemy.setEnemyMovementRight(false);
            // Enemy sprite setup
            String enemyURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/ufo.png";
            Image enemySprite = new Image(enemyURL,50,50,false,true);
            ImageView theEnemy = new ImageView();
            theEnemy.setImage(enemySprite);
            // Sets Layout and adds enemy and sprite to the scene and corrseponding arrays
            theEnemy.setLayoutX(enemy.getX_Coordinate());
            theEnemy.setLayoutY(enemy.getY_Coordinate());

            enemies.add(enemy);
            theEnemies.add(theEnemy);
            root.getChildren().add(theEnemy);

            x++;
        }
    }
    /**
     * Method that allows the player to shoot projectiles
     */
    public void shootProjectile(){
        // Creates Projectile
        Projectile bullet = new Projectile(player.getX_Coordinate(), player.getY_Coordinate(), 20, 40, true);
        // Creates Procetile sprite
        String bulletURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/missle.png";
        Image bulletSprite = new Image(bulletURL,20,50,false,true);
        ImageView theBullet = new ImageView();
        theBullet.setImage(bulletSprite);
        // Spawns Projectile @ player location
        theBullet.setLayoutX(bullet.getX_Coordinate());
        theBullet.setLayoutY(bullet.getY_Coordinate());
        // adds projectile and sprite to scene and arraylists
        bullets.add(bullet);
        theBullets.add(theBullet);
        root.getChildren().add(theBullet);
    }
    /**
     * Method that shoots projectiles from the enemies
     */
    public void shootEnemyProjectile(){
        // One enemy will randomly shoot
        Enemy enemyBullet = enemies.get(randomNumber.nextInt(enemies.size()));
        // Creates Projectile
        Projectile bullet = new Projectile(enemyBullet.getX_Coordinate(), enemyBullet.getY_Coordinate(), 20, 40, false);
        // Creates Procetile sprite
        String bulletURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/pew.png";
        Image bulletSprite = new Image(bulletURL,20,50,false,true);
        ImageView theBullet = new ImageView();
        theBullet.setImage(bulletSprite);
        // Spawns Projectile @ enemy location
        theBullet.setLayoutX(bullet.getX_Coordinate());
        theBullet.setLayoutY(bullet.getY_Coordinate());
        // adds projectile and sprite to scene and arraylists
        enemyBullets.add(bullet);
        theEnemyBullets.add(theBullet);
        root.getChildren().add(theBullet);
    }

// Main game/GUI
/**
 * Sets up the GUI and starts the stage
 * @param primaryStage
 */

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Sets up Player Sprite
        String playerURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/player.png";
        Image playerSprite = new Image(playerURL,50,50,false,true);
        ImageView thePlayer = new ImageView();
        thePlayer.setImage(playerSprite);
        thePlayer.setLayoutY(player.getY_Coordinate());
        thePlayer.setLayoutX(player.getX_Coordinate());
        // Sets up Backround image
        String bgURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/bg.png";
        Image bg = new Image(bgURL, 1000,1000,false,true);
        ImageView theBG = new ImageView();
        theBG.setImage(bg);
        // Sets up Game Over
        String goURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/game%20over.png";
        Image go = new Image(goURL, 375,190,false,true);
        ImageView gameOver = new ImageView();
        gameOver.setImage(go);
        gameOver.setLayoutX(1500);
        gameOver.setLayoutY(1500);

// Sets up main controls
// Player holds a and d to move left and right respectivly
// Player taps then releases space to shoot
// Uses R.N.G to determine if enemies shoot

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                    switch (event.getCode()) {

                        case D:
                            movingRight = true;
                            int random1 = randomNumber.nextInt(2);
                            if (random1 == 0 && player.getLive() == true)
                                shootEnemyProjectile();
                        break;

                        case A:
                            movingLeft = true;
                            int random2 = randomNumber.nextInt(2);
                            if (random2 == 0 && player.getLive() == true)
                                shootEnemyProjectile();
                        break;

                        case SPACE:
                            fireShot = true;
                        break;
                    }
                
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case D:
                        movingRight = false;
                        int random1 = randomNumber.nextInt(2);
                            if (random1 == 0 && player.getLive() == true)
                                shootEnemyProjectile();
                    break;

                    case A:
                        movingLeft = false;
                        int random2 = randomNumber.nextInt(2);
                            if (random2 == 0 && player.getLive() == true)
                                shootEnemyProjectile();
                    break;

                    case SPACE: 
                        if (fireShot && player.getLive())
                            shootProjectile();
                        fireShot = false;
                        break;
                }
            }
        });
        // Sets up Stage and spawns in enemies
        root.getChildren().add(theBG);
        spawnEnemies(35);
        root.getChildren().add(gameOver);
        root.getChildren().add(thePlayer);

        primaryStage.setTitle("Intergalactic Assailants");
        primaryStage.getIcons().add(new Image(Runner.class.getResourceAsStream("moon.png"))); 
        primaryStage.setScene(scene);
        primaryStage.show();

// Animation Timers
// Each timer controls a diffrent game aspect
        // Handles Player movement based on player input
        AnimationTimer timerPlayer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (movingLeft) {
                    if(ifPlayerCanMove == true){
                        if (player.getX_Coordinate() > 5){
                            player.moveLeft();
                            thePlayer.setLayoutX(player.getX_Coordinate());
                        }   
                    }
                }

                if (movingRight){
                    if(ifPlayerCanMove == true){
                        if (player.getX_Coordinate() < 950){
                            player.moveRight();
                            thePlayer.setLayoutX(player.getX_Coordinate());
                        }
                    }
                }
            }
        };
        // Moves and despawns Enemies based on life state
        AnimationTimer timerEnemy = new AnimationTimer(){

            @Override
            public void handle(long now) {

                if (player.getLive()){
                    for(int i = 0; i<enemies.size(); i++){

                        if (enemies.get(i).getLive()){
                            enemies.get(i).enemyMovement(player);
                            theEnemies.get(i).setLayoutX(enemies.get(i).getX_Coordinate());
                            theEnemies.get(i).setLayoutY(enemies.get(i).getY_Coordinate());
                        }
                    // Relocates enemies after death to avoid collosion with invisible, dead enemies
                    // Removes enemies from list to increase fire rate of remaining enemies 
                        if (enemies.get(i).getLive() == false){
                            enemies.get(i).setXCoordinate(1100);
                            enemies.get(i).setYCoordinate(1100);
                            root.getChildren().remove(theEnemies.get(i));
                            theEnemies.remove(theEnemies.get(i));
                            enemies.remove(enemies.get(i));
                        }
                    }
                }
            }
        };
        // Moves Projectiles and checks for collisions with enemy
        AnimationTimer timerBullets = new AnimationTimer(){
        
            @Override
            public void handle(long now) {
                for(int i = 0; i<bullets.size(); i++){

                    if (bullets.get(i).getLive() == true && bullets.get(i).getY_Coordinate() < 1100){
                        bullets.get(i).projectileMovement();
                        theBullets.get(i).setLayoutY(bullets.get(i).getY_Coordinate());
                    }

                    for (int e = 0; e < enemies.size(); e++){
                        if (bullets.get(i).getProjectileBoundary().intersects(enemies.get(e).getEnemyBoundary()) && bullets.get(i).getLive() == true){
                            enemies.get(e).setLive(false);
                            bullets.get(i).setLive(false);
                            root.getChildren().remove(theBullets.get(i));
                        }
                    }
                }
            }
        };
        // Moves Enemy Projectiles
        AnimationTimer timerEnemyBullets = new AnimationTimer(){
        
            @Override
            public void handle(long now) {
                for(int i = 0; i<enemyBullets.size(); i++){

                    if (enemyBullets.get(i).getLive() == true && enemyBullets.get(i).getY_Coordinate() > 0){
                        enemyBullets.get(i).projectileMovement();
                        theEnemyBullets.get(i).setLayoutY(enemyBullets.get(i).getY_Coordinate());
                    }

                    if (enemyBullets.get(i).getProjectileBoundary().intersects(player.getPlayerBoundary())){
                        player.setLive(false);
                        ifPlayerCanMove = false;
                        root.getChildren().remove(thePlayer);
                        gameOver.setLayoutX(500-(375/2));
                        gameOver.setLayoutY(500-(190/2));
                    }
                }
            }
        };

        timerPlayer.start();
        timerEnemy.start();
        timerBullets.start();
        timerEnemyBullets.start();
    }
}