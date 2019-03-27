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
import java.io.*;
import java.util.*;

/**
 * Main menu screen for the game
 */

public class GUI extends Application {

    private static String filePath = System.getProperty("user.dir");
    private static int aEnemiesToSpawn, aEnemiesKilled, aEnemyMovementSpeed, aEnemyProjectileSpeed, aWavesKilled,
            aScore;

    // Background Music
    int maxVolume = 100;
    int volume = 40;
    static String Backgroundmsc = filePath + "\\SFX\\8_Bit_March.mp3";
    static Media Backgroundsnd = new Media(new File(Backgroundmsc).toURI().toString());
    static MediaPlayer playBackgroundmsc = new MediaPlayer(Backgroundsnd);
    float log1 = (float) (Math.log(maxVolume - volume) / Math.log(maxVolume));

    /**
     * Method that plays a sound when a button is clicked on
     */
    public static void btnClickSound() {
        String btnClickSound = filePath + "\\SFX\\casual-death-loose.wav";
        MediaPlayer playbtnClickSound = new MediaPlayer(new Media(new File(btnClickSound).toURI().toString()));
        playbtnClickSound.play();
    }

    /**
     * Method that stops background music
     */
    public static void stopBackgroundMusic() {
        playBackgroundmsc.stop();
    }

    /**
     * Method that starts background music
     */
    public static void startBackgroundMusic() {
        playBackgroundmsc.play();
    }

    @Override
    public void start(Stage stage) throws Exception {

        playBackgroundmsc.setOnEndOfMedia(new Runnable() {
            public void run() {
                playBackgroundmsc.stop();
                playBackgroundmsc.play();
            }
        });
        playBackgroundmsc.setVolume(1 - log1);
        startBackgroundMusic();

        Pane root = new Pane();
        /**
         * Setting up images
         */
        FileInputStream titleBg = new FileInputStream(filePath + "\\Textures\\space.png");
        Image titleScreen = new Image(titleBg, 1920, 1080, false, true);
        FileInputStream titleText = new FileInputStream(filePath + "\\Textures\\title.png");
        Image title = new Image(titleText, 777, 174, false, true);
        FileInputStream playPath = new FileInputStream(filePath + "\\Textures\\start.png");
        Image playButton = new Image(playPath, 269, 84, false, true);
        FileInputStream exitPath = new FileInputStream(filePath + "\\Textures\\exit.png");
        Image exitButton = new Image(exitPath, 267, 84, false, true);
        FileInputStream iconPath = new FileInputStream(filePath + "\\Textures\\moon.png");
        Image icon = new Image(iconPath, 50, 50, false, true);

        ImageView imageView = new ImageView();
        imageView.setImage(titleScreen);

        ImageView titleNode = new ImageView();
        titleNode.setImage(title);

        Button play_button = new Button();
        ImageView playButtonNode = new ImageView();
        playButtonNode.setImage(playButton);
        play_button.setGraphic(playButtonNode);
        play_button
                .setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        play_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Starts the game when the button is pressed
            public void handle(ActionEvent start) {
                try {
                    Runner.startGame(stage, 0, 5, 9, 20, 0, 0);
                    btnClickSound();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        Button exit_button = new Button();
        ImageView exitButtonNode = new ImageView();
        exitButtonNode.setImage(exitButton);
        exit_button.setGraphic(exitButtonNode);
        exit_button
                .setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        exit_button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            // Exits the game when button is pressed
            public void handle(ActionEvent exit) {
                System.exit(0);
            }
        });

        // Create load button
        FileInputStream loadPath = new FileInputStream(filePath + "\\Textures\\load.png");
        Image loadButton = new Image(loadPath, 269, 84, false, true);
        Button load_button = new Button();
        ImageView loadButtonNode = new ImageView();
        loadButtonNode.setImage(loadButton);
        load_button.setGraphic(loadButtonNode);
        load_button
                .setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        load_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            // Reads a text file that contains score and state of when the game was saved
            // and restarts the game from that state
            public void handle(ActionEvent save) {
                try {
                    FileReader freader = new FileReader(filePath + "\\savegame.txt");
                    BufferedReader breader = new BufferedReader(freader);
                    for (int i = 1; i < 7; i++) {
                        if (i == 1)
                            aScore = Integer.parseInt(breader.readLine());
                        if (i == 2)
                            aEnemyMovementSpeed = Integer.parseInt(breader.readLine());
                        if (i == 3)
                            aEnemyProjectileSpeed = Integer.parseInt(breader.readLine());
                        if (i == 4)
                            aEnemiesToSpawn = Integer.parseInt(breader.readLine());
                        if (i == 5)
                            aWavesKilled = Integer.parseInt(breader.readLine());
                        if (i == 6)
                            aEnemiesKilled = Integer.parseInt(breader.readLine());
                    }
                    breader.close();
                    Runner.startGame(stage, aScore, aEnemyMovementSpeed, aEnemyProjectileSpeed,
                            ((20 + (2 * aWavesKilled)) - aEnemiesKilled), aWavesKilled, aEnemiesKilled);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                btnClickSound();
            }
        });
        load_button.setLayoutX(500);
        load_button.setLayoutY(600);
        loadButtonNode.setLayoutX(500);
        loadButtonNode.setLayoutY(600);

        // Creates scoreboard button
        FileInputStream scoreboardPath = new FileInputStream(filePath + "\\Textures\\save.png");
        Image scoreboardButton = new Image(scoreboardPath, 300, 90, false, true);
        Button scoreboard_button = new Button();
        ImageView scoreboardButtonNode = new ImageView();
        scoreboardButtonNode.setImage(scoreboardButton);
        scoreboard_button.setGraphic(scoreboardButtonNode);
        scoreboard_button
                .setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        scoreboard_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent showscoreboard) {
                try {
                    FileReader freader = new FileReader(filePath + "\\scoreboard.txt");
                    BufferedReader breader = new BufferedReader(freader);
                    ArrayList<Integer> scoreArray = new ArrayList<Integer>();
                    while (breader.readLine() != null) {
                        int line = Integer.parseInt(breader.readLine());
                        scoreArray.add(line);
                    }
                    breader.close();
                    btnClickSound();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        // Layout for all images and buttons
        scoreboard_button.setLayoutX(1500);
        scoreboard_button.setLayoutY(1500);
        scoreboardButtonNode.setLayoutX(1500);
        scoreboardButtonNode.setLayoutY(1500);

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

        root.getChildren().addAll(imageView, titleNode, play_button, exit_button, load_button, loadButtonNode);
        Scene scene = new Scene(root, 1300, 730);
        stage.setTitle("Intergalactic Assailants");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

}