import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Main menu screen for the game 19.03.15
 */

public class GUI extends Application {

    private static String filePath = System.getProperty("user.dir");

    // Background Music
    static String Backgroundmsc = filePath + "\\SFX\\8_Bit_March.mp3";
    static Media Backgroundsnd = new Media(new File(Backgroundmsc).toURI().toString());
    static MediaPlayer playBackgroundmsc = new MediaPlayer(Backgroundsnd);

    public static void stopBackroundMusic(){
        playBackgroundmsc.stop();
    }

    @Override
    public void start(Stage stage) throws Exception {

        playBackgroundmsc.setOnEndOfMedia(new Runnable() {
            public void run() {
              playBackgroundmsc.stop();
              playBackgroundmsc.play();
            }
        });
        playBackgroundmsc.play();

        Pane root = new Pane();

        FileInputStream titleBg = new FileInputStream(filePath + "\\Textures\\space.png");
        Image titleScreen = new Image(titleBg, 1920, 1080, false, true);
        FileInputStream titleText = new FileInputStream(filePath + "\\Textures\\title.png");
        Image title = new Image(titleText, 777, 174, false, true);
        FileInputStream playPath = new FileInputStream(filePath + "\\Textures\\start.png");
        Image playButton = new Image(playPath, 269, 84, false, true);
        FileInputStream exitPath = new FileInputStream(filePath + "\\Textures\\exit.png");
        Image exitButton = new Image(exitPath, 267, 82, false, true);
        FileInputStream scorePath = new FileInputStream(filePath + "\\Textures\\score.png");
        Image score = new Image(scorePath, 186, 44, false, true);

        ImageView scoreNode = new ImageView();
        scoreNode.setImage(score);

        ImageView imageView = new ImageView();
        imageView.setImage(titleScreen);

        ImageView titleNode = new ImageView();
        titleNode.setImage(title);

        Button play_button = new Button();
        ImageView playButtonNode = new ImageView();
        playButtonNode.setImage(playButton);
        play_button.setGraphic(playButtonNode);
        play_button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        play_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent exit) {
                try {
                    Runner.startGame(stage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        Button exit_button = new Button();
        ImageView exitButtonNode = new ImageView();
        exitButtonNode.setImage(exitButton);
        exit_button.setGraphic(exitButtonNode);
        exit_button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        exit_button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent exit) {
                System.exit(0);
            }
        });

        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        imageView.setFitHeight(1080);
        imageView.setFitWidth(1300);
        imageView.setPreserveRatio(true);

        titleNode.setLayoutX(250);
        titleNode.setLayoutY(180);

        play_button.setLayoutX(500);
        play_button.setLayoutY(400);
        playButtonNode.setLayoutX(500);
        playButtonNode.setLayoutY(400);

        exit_button.setLayoutX(500);
        exit_button.setLayoutY(500);
        exitButtonNode.setLayoutX(500);
        exitButtonNode.setLayoutY(500);

        scoreNode.setLayoutX(950);
        scoreNode.setLayoutY(620);

        root.getChildren().addAll(imageView, titleNode, play_button, exit_button);
        Scene scene = new Scene(root, 1300, 730);
        stage.setTitle("Intergalactic Assailants");
        stage.setScene(scene);
        stage.show();
    }

}