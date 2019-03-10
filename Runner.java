import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.*;

public class Runner extends Application{

    Player player = new Player(500, 800);

    Enemy enemy = new Enemy(50, 50);

    boolean movingRight, movingLeft;

    @Override
    public void start(Stage primaryStage) throws Exception{

        String enemyURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/ufo.png";
        Image enemySprite = new Image(enemyURL,50,50,false,true);
        ImageView theEnemy = new ImageView();
        theEnemy.setImage(enemySprite);

        String playerURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/player.png";
        Image playerSprite = new Image(playerURL,50,50,false,true);
        ImageView thePlayer = new ImageView();
        thePlayer.setImage(playerSprite);
        thePlayer.setLayoutY(player.getY_Coordinate());

        Pane root = new Pane();
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

        root.getChildren().add(thePlayer);
        root.getChildren().add(theEnemy);

        primaryStage.setTitle("Intergalactic Assailants");
        primaryStage.setScene(scene);
        primaryStage.show();

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
}