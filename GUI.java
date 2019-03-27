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

import java.awt.Font;
import java.awt.Label;
import java.io.*;
import java.util.*;

/**
 * Main menu screen for the game 19.03.15
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

    public static void btnClickSound() {
        String btnClickSound = filePath + "\\SFX\\casual-death-loose.wav";
        MediaPlayer playbtnClickSound = new MediaPlayer(new Media(new File(btnClickSound).toURI().toString()));
        playbtnClickSound.play();
    }

    public static void stopBackgroundMusic() {
        playBackgroundmsc.stop();
    }

    public static void startBackgroundMusic() {
        playBackgroundmsc.play();
    }

    // Reads the scoreboard
    public static ArrayList<Integer> readscoreboard() {
        ArrayList<Integer> scoreArray = new ArrayList<Integer>();
        try {
            FileReader freader = new FileReader(filePath + "\\scoreboard.txt");
            BufferedReader breader = new BufferedReader(freader);
            while (breader.readLine() != null) {
                int line = Integer.parseInt(breader.readLine());
                scoreArray.add(line);
            }
            breader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scoreArray;
    }

    public void createTop5Scores(ArrayList<Integer> scoreArray) {
        for (int i = 0; i < 5; i++) {
            FileInputStream fontStream = new FileInputStream(filePath + "\\Textures\\04B_30__.TTF");
            Font f = Font.loadFont(fontStream, 34);
            String scoreString = Integer.toString(scoreArray.get(0));
            Label score = new Label(scoreString);
            score.setFont(f);
            score.setTextFill(Color.rgb(255, 193, 170));
            score.setLayoutX(900);
            score.setLayoutX(50 + i * 50);
        }
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
        play_button
                .setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        play_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
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
            public void handle(ActionEvent exit) {
                System.exit(0);
            }
        });

        FileInputStream fontStream = new FileInputStream(filePath + "\\Textures\\04B_30__.TTF");
        Font f = Font.loadFont(fontStream, 34);
        // Sets up scoreboard
        Image scoreboard = new Image(scorePath, 186, 44, false, true);
        ImageView scoreboardText = new ImageView();
        scoreboardText.setImage(scoreboard);
        scoreboardText.setLayoutX(900);
        scoreboardText.setLayoutY(0);
        // Sets up scoreboard label
        ArrayList<Integer> scoreArray = readscoreboard();
        if (scoreArray.size() >= 5) {
            String scoreString1 = Integer.toString(scoreArray.get(0));
            String scoreString2 = Integer.toString(scoreArray.get(1));
            String scoreString3 = Integer.toString(scoreArray.get(2));
            String scoreString4 = Integer.toString(scoreArray.get(3));
            String scoreString5 = Integer.toString(scoreArray.get(4));
        }
        Label score1 = new Label(scoreString1);
        Label score2 = new Label(scoreString2);
        Label score3 = new Label(scoreString3);
        Label score4 = new Label(scoreString4);
        Label score5 = new Label(scoreString5);
        score1.setFont(f);
        score1.setTextFill(Color.rgb(255, 193, 170));
        score1.setLayoutX(900);
        score1.setLayoutY(50);
        score2.setFont(f);
        score2.setTextFill(Color.rgb(255, 193, 170));
        score2.setLayoutX(900);
        score2.setLayoutY(100);
        score3.setFont(f);
        score3.setTextFill(Color.rgb(255, 193, 170));
        score3.setLayoutX(900);
        score3.setLayoutY(150);
        score4.setFont(f);
        score4.setTextFill(Color.rgb(255, 193, 170));
        score4.setLayoutX(900);
        score4.setLayoutY(200);
        score5.setFont(f);
        score5.setTextFill(Color.rgb(255, 193, 170));
        score5.setLayoutX(900);
        score5.setLayoutY(250);

        // Create load button
        FileInputStream loadPath = new FileInputStream(filePath + "\\Textures\\load.png");
        Image loadButton = new Image(loadPath, 300, 90, false, true);
        Button load_button = new Button();
        ImageView loadButtonNode = new ImageView();
        loadButtonNode.setImage(loadButton);
        load_button.setGraphic(loadButtonNode);
        load_button
                .setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        load_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
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

        root.getChildren().addAll(imageView, titleNode, play_button, exit_button, load_button, loadButtonNode);
        Scene scene = new Scene(root, 1300, 730);
        stage.setTitle("Intergalactic Assailants");
        stage.setScene(scene);
        stage.show();
    }

}