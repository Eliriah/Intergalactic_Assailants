import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.*;

public class Runner extends Application{

    Pane root = new Pane();
    Scene scene = new Scene(root, 1000, 1000);

    Player player = new Player(500, 800, 50, 50);

    boolean movingRight, movingLeft, fireShot;
    
    static boolean ifPlayerCanMove = true;
    
    public static void setIfPlayerCanMove(boolean a){
        ifPlayerCanMove = a;
    }

    ArrayList<Projectile> bullets = new ArrayList<Projectile>();

    ArrayList<ImageView> theBullets = new ArrayList<ImageView>();

    ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    ArrayList<ImageView> theEnemies = new ArrayList<ImageView>();

    public void spawnEnemies(int numberOfEnemies){

        int x = 0;
        int y = 0;

        for(int i = 0; i < numberOfEnemies; i++){

            if ((50 + (x * 50)) == 950){
                x = 0;
                y++;
            }

            Enemy enemy = new Enemy((50 + (x * 50)), (50 + (y * 50)), 50, 50);

            if (y%2 != 0)
                enemy.setEnemyMovementRight(false);

            String enemyURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/ufo.png";
            Image enemySprite = new Image(enemyURL,50,50,false,true);
            ImageView theEnemy = new ImageView();
            theEnemy.setImage(enemySprite);

            theEnemy.setLayoutX(enemy.getX_Coordinate());
            theEnemy.setLayoutY(enemy.getY_Coordinate());

            enemies.add(enemy);
            theEnemies.add(theEnemy);
            root.getChildren().add(theEnemy);

            x++;
        }
    }

    public void shootProjectile(){

        Projectile bullet = new Projectile(player.getX_Coordinate(), player.getY_Coordinate(), 20, 50, true);

        String bulletURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/missle.png";
        Image bulletSprite = new Image(bulletURL,20,50,false,true);
        ImageView theBullet = new ImageView();
        theBullet.setImage(bulletSprite);

        theBullet.setLayoutX(bullet.getX_Coordinate());
        theBullet.setLayoutY(bullet.getY_Coordinate());

        bullets.add(bullet);
        theBullets.add(theBullet);
        root.getChildren().add(theBullet);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        String playerURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/player.png";
        Image playerSprite = new Image(playerURL,50,50,false,true);
        ImageView thePlayer = new ImageView();
        thePlayer.setImage(playerSprite);
        thePlayer.setLayoutY(player.getY_Coordinate());

        String bgURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/bg.png";
        Image bg = new Image(bgURL, 1000,1000,false,true);
        ImageView theBG = new ImageView();
        theBG.setImage(bg);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                        case D: movingRight = true; break;
                        case A: movingLeft = true; break;
                        case SPACE: fireShot = true; break;
                    }
                
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case D: movingRight = false; break;
                    case A: movingLeft = false; break;
                    case SPACE: 
                        if (fireShot)
                            shootProjectile();
                        fireShot = false;
                        break;
                }
            }
        });

        root.getChildren().add(theBG);
        spawnEnemies(35);
        root.getChildren().add(thePlayer);

        primaryStage.setTitle("Intergalactic Assailants");
        primaryStage.setScene(scene);
        primaryStage.show();

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

        AnimationTimer timerEnemy = new AnimationTimer(){
        
            @Override
            public void handle(long now) {

                for(int i = 0; i<enemies.size(); i++){

                    if (enemies.get(i).getLive()){
                        enemies.get(i).enemyMovement(player);
                        theEnemies.get(i).setLayoutX(enemies.get(i).getX_Coordinate());
                        theEnemies.get(i).setLayoutY(enemies.get(i).getY_Coordinate());
                }
                    if (enemies.get(i).getLive() == false){
                        root.getChildren().remove(theEnemies.get(i));
                        enemies.get(i).setXCoordinate(1100);
                        enemies.get(i).setYCoordinate(1100);
                    }
                }
            }
        };

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

        timerPlayer.start();
        timerBullets.start();
        timerEnemy.start();

    }
}