import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class Runner extends Application {

    Player player = new Player(500, 800);
    Rectangle thePlayer = new Rectangle(player.getX_Coordinate(), player.getY_Coordinate(), 50, 50);
    Node player1 = thePlayer;

    Enemy enemy = new Enemy(50, 50);
    Rectangle theEnemy = new Rectangle(enemy.getX_Coordinate(), enemy.getY_Coordinate(), 50, 50);
    Node enemy1 = theEnemy;

    boolean movingLeft, movingRight;

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group(player1, enemy1);

        Scene scene = new Scene(root, 1000, 1000);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case D: movingRight = true; break;
                    case A: movingLeft = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case D: movingRight = false; break;
                    case A: movingLeft = false; break;
                }
            }
        });

        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (movingLeft) {
                    player.moveLeft();
                    thePlayer.setLayoutX(player.getX_Coordinate());
                }

                if (movingRight){
                    player.moveRight();
                    thePlayer.setLayoutX(player.getX_Coordinate());
                }

                enemy.enemyMovement();
                theEnemy.setLayoutX(enemy.getX_Coordinate());
                theEnemy.setLayoutY(enemy.getY_Coordinate());
            }
        };
        timer.start();
    }
    public static void main(String[] args) { launch(args); }
}