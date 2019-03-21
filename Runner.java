import java.util.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import java.io.*;

public abstract class Runner extends Application {

    // Instance Variables

    private static Pane root = new Pane();
    private static Scene scene = new Scene(root, 1000, 1000);
    private static Player player = new Player(500, 800, 40, 40);
    private static boolean movingRight, movingLeft, fireShot;
    private static int enemiesToSpawn, enemiesKilled, enemyMovementSpeed, enemyProjectileSpeed, wavesKilled, score;
    private static String filePath = System.getProperty("user.dir");

    // R.N.G.

    static Random randomNumber = new Random();

    // Arraylists

    private static ArrayList<Projectile> bullets = new ArrayList<Projectile>();
    private static ArrayList<ImageView> theBullets = new ArrayList<ImageView>();

    private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private static ArrayList<ImageView> theEnemies = new ArrayList<ImageView>();

    private static ArrayList<Projectile> enemyBullets = new ArrayList<Projectile>();
    private static ArrayList<ImageView> theEnemyBullets = new ArrayList<ImageView>();

    // Methods for Spawning game elements

    public static void spawnEnemies(int numberOfEnemies) throws FileNotFoundException {
        // Used to seperate Enemy Spawns
        int x = 0;
        int y = 0;
        for (int i = 0; i < numberOfEnemies; i++) {
            // Checks if spawns have reached the outer limit of the game board
            if ((50 + (x * 100)) == 950) {
                x = 0;
                y++;
            }
            Enemy enemy = new Enemy((50 + (x * 100)), (50 + (y * 50)), 50, 50);
            // Enemy moves left or right based on y value
            if (y % 2 != 0)
                enemy.setEnemyMovementRight(false);
            // Enemy sprite setup
            FileInputStream enemyPath = new FileInputStream(filePath + "\\Textures\\ufo.png");
            Image enemySprite = new Image(enemyPath, 50, 50, false, true);
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

    public static void shootProjectile() throws FileNotFoundException {
        // Creates Projectile
        Projectile bullet = new Projectile(player.getX_Coordinate(), player.getY_Coordinate(), 20, 40, true);
        // Creates Procetile sprite
        FileInputStream bulletPath = new FileInputStream(filePath + "\\Textures\\missle.png");
        Image bulletSprite = new Image(bulletPath, 20, 50, false, true);
        ImageView theBullet = new ImageView();
        theBullet.setImage(bulletSprite);
        // Spawns Projectile @ player location
        theBullet.setLayoutX(bullet.getX_Coordinate());
        theBullet.setLayoutY(bullet.getY_Coordinate());
        // adds projectile and sprite to scene and arraylists
        bullets.add(bullet);
        theBullets.add(theBullet);
        root.getChildren().add(theBullet);
        // SFX
        String filePath = System.getProperty("user.dir");
        String pewSound = filePath + "\\SFX\\pew.wav";
        Media sound = new Media(new File(pewSound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public static void shootEnemyProjectile() throws FileNotFoundException {
        // One enemy will randomly shoot
        Enemy enemyBullet = enemies.get(randomNumber.nextInt(enemies.size()));
        // Creates Projectile
        Projectile bullet = new Projectile(enemyBullet.getX_Coordinate(), enemyBullet.getY_Coordinate(), 20, 40, false);
        // Creates Procetile sprite
        FileInputStream bulletPath = new FileInputStream(filePath + "\\Textures\\pew.png");
        Image bulletSprite = new Image(bulletPath, 20, 50, false, true);
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

    public static void spawnWaves(){
        // Spawns new Waves of enemies
        if (enemiesKilled == enemiesToSpawn){
            wavesKilled ++;
            enemiesKilled = 0;
            // increases amount of enemies by 2 per wave killed
            if (enemiesToSpawn < 40)
                enemiesToSpawn += 2;
            // increases speed of enemies every other wave
            if (wavesKilled % 2 == 0)
                enemyMovementSpeed ++;
            // increases projectile speed every 4th wave killed
            if (wavesKilled % 4 == 0)
                enemyProjectileSpeed ++;
            try {
                spawnEnemies(enemiesToSpawn);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    // Main game/GUI
    public static void startGame(Stage primaryStage) throws FileNotFoundException {
        // Sets up non-enemy/bullet spites and other images
    
        String loserMsc = filePath + "\\SFX\\Naruto - Sadness and Sorrow 8 Bit.Mp3";
        Media loserSnd = new Media(new File(loserMsc).toURI().toString());
        MediaPlayer playLoserMsc = new MediaPlayer(loserSnd);
        // Sets up Player Sprite
        FileInputStream playerPath = new FileInputStream(filePath + "\\Textures\\player.png");
        Image playerSprite = new Image(playerPath, 50, 50, false, true);
        ImageView thePlayer = new ImageView();
        thePlayer.setImage(playerSprite);
        thePlayer.setLayoutY(player.getY_Coordinate());
        thePlayer.setLayoutX(player.getX_Coordinate());
        // Sets up Backround image
        FileInputStream bgPath = new FileInputStream(filePath + "\\Textures\\bg.png");
        Image bg = new Image(bgPath, 1000, 1000, false, true);
        ImageView theBG = new ImageView();
        theBG.setImage(bg);
        // Sets up Game Over
        FileInputStream goPath = new FileInputStream(filePath + "\\Textures\\game over.png");
        Image go = new Image(goPath, 375, 190, false, true);
        ImageView gameOver = new ImageView();
        gameOver.setImage(go);
        gameOver.setLayoutX(1500);
        gameOver.setLayoutY(1500);
        // Sets up Score
        FileInputStream scorePath = new FileInputStream(filePath + "\\Textures\\score.png");
        Image scoreI = new Image(scorePath, 186, 44, false, true);
        ImageView scoreText = new ImageView();
        scoreText.setImage(scoreI);
        scoreText.setLayoutX(350);
        scoreText.setLayoutY(900);
        // sets up Score label
        score = 0;
        String aScore = score + "";
        Label theScore = new Label(aScore);
        theScore.setLayoutX(570);
        theScore.setLayoutY(915);

        // Sets up main controls
        // Player holds a and d to move left and right respectivly
        // Player taps then releases space to shoot
        // Uses R.N.G to determine if enemies shoot

        enemyMovementSpeed = 5;
        enemyProjectileSpeed = 9;
        enemiesToSpawn = 20;
        enemiesKilled = 0;

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {

                case D:
                    movingRight = true;
                    spawnWaves();
                    int random1 = randomNumber.nextInt(2);
                    if (random1 == 0 && player.getLive() == true)
                        try {
                            shootEnemyProjectile();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    break;

                case A:
                    movingLeft = true;
                    spawnWaves();
                    int random2 = randomNumber.nextInt(2);
                    if (random2 == 0 && player.getLive() == true)
                        try {
                            shootEnemyProjectile();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    break;

                case SPACE:
                    spawnWaves();
                    fireShot = true;
                    if (player.getLive() == true)
                        try {
                            shootEnemyProjectile();
                            shootEnemyProjectile();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
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
                    spawnWaves();
                    int random1 = randomNumber.nextInt(2);
                    if (random1 == 0 && player.getLive() == true)
                        try {
                            shootEnemyProjectile();
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    break;

                case A:
                    movingLeft = false;
                    spawnWaves();
                    int random2 = randomNumber.nextInt(2);
                    if (random2 == 0 && player.getLive() == true)
                        try {
                            shootEnemyProjectile();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    break;

                case SPACE:
                    spawnWaves();
                    if (fireShot && player.getLive())
                        try {
                            shootProjectile();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    fireShot = false;
                    break;
                }
            }
        });
        // Sets up Stage and spawns in enemies

        root.getChildren().add(theBG);
        spawnEnemies(enemiesToSpawn);
        root.getChildren().add(gameOver);
        root.getChildren().add(scoreText);
        root.getChildren().add(thePlayer);
        root.getChildren().add(theScore);

        primaryStage.setTitle("Intergalactic Assailants");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Animation Timers
        // Each timer controls a diffrent game aspect
        // Handles Player movement based on player input
        AnimationTimer timerPlayer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (movingLeft) {
                    if (player.getLive() == true) {
                        if (player.getX_Coordinate() > 5) {
                            player.moveLeft(5);
                            thePlayer.setLayoutX(player.getX_Coordinate());
                        }
                    }
                }

                if (movingRight) {
                    if (player.getLive() == true) {
                        if (player.getX_Coordinate() < 950) {
                            player.moveRight(5);
                            thePlayer.setLayoutX(player.getX_Coordinate());
                        }
                    }
                }
            }
        };
        // Moves and despawns Enemies based on life state
        AnimationTimer timerEnemy = new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (player.getLive()) {
                    for (int i = 0; i < enemies.size(); i++) {

                        if (enemies.get(i).getLive() && player.getLive()) {
                            enemies.get(i).enemyMovement(enemyMovementSpeed);
                            theEnemies.get(i).setLayoutX(enemies.get(i).getX_Coordinate());
                            theEnemies.get(i).setLayoutY(enemies.get(i).getY_Coordinate());
                            if (enemies.get(i).getUnitHitBox().intersects(player.getUnitHitBox()))
                                player.setLive(false);
                        }
                        // Relocates enemies after death to avoid collosion with invisible, dead enemies
                        // Removes enemies from list to increase fire rate of remaining enemies
                        // Checks if all enemies have died, ends game if they have
                        if (player.getLive() == false) {
                            gameOver.setLayoutX(500 - (375 / 2));
                            gameOver.setLayoutY(500 - (190 / 2));
                            GUI.stopBackroundMusic();
                            playLoserMsc.play();
                        }
                        if (enemies.get(i).getLive() == false) {
                            enemies.get(i).setXCoordinate(1100);
                            enemies.get(i).setYCoordinate(1100);
                            root.getChildren().remove(theEnemies.get(i));
                            theEnemies.remove(theEnemies.get(i));
                            enemies.remove(enemies.get(i));

                            enemiesKilled++;

                            score += 100;
                            String aScoreChange = score + "";
                            theScore.setText(aScoreChange);
                        }
                    }
                }
            }
        };
        // Moves Projectiles and checks for collisions with enemy
        AnimationTimer timerBullets = new AnimationTimer() {

            @Override
            public void handle(long now) {
                for (int i = 0; i < bullets.size(); i++) {
                    // Collision for projectiles
                    if (bullets.get(i).getLive() == true && bullets.get(i).getY_Coordinate() < 1100) {
                        bullets.get(i).projectileMoving(7);
                        theBullets.get(i).setLayoutY(bullets.get(i).getY_Coordinate());
                    }
                    // Collision for enemies
                    for (int e = 0; e < enemies.size(); e++) {
                        if (bullets.get(i).getUnitHitBox().intersects(enemies.get(e).getUnitHitBox()) && bullets.get(i).getLive() == true) {
                            enemies.get(e).setLive(false);
                            bullets.get(i).setLive(false);
                            root.getChildren().remove(theBullets.get(i));
                        }
                    }
                }
            }
        };
        // Moves Enemy Projectiles
        AnimationTimer timerEnemyBullets = new AnimationTimer() {

            @Override
            public void handle(long now) {
                for (int i = 0; i < enemyBullets.size(); i++) {

                    if (enemyBullets.get(i).getLive() == true && enemyBullets.get(i).getY_Coordinate() > 0) {
                        enemyBullets.get(i).projectileMoving(enemyProjectileSpeed);
                        theEnemyBullets.get(i).setLayoutY(enemyBullets.get(i).getY_Coordinate());
                    }

                    if (enemyBullets.get(i).getUnitHitBox().intersects(player.getUnitHitBox())) {
                        player.setLive(false);
                        root.getChildren().remove(thePlayer);
                        gameOver.setLayoutX(500 - (375 / 2));
                        gameOver.setLayoutY(500 - (190 / 2));
                        GUI.stopBackroundMusic();
                        playLoserMsc.play();
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