import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class GUI extends Application {  
    public static void main(String args[]) { 
        launch(args); 
    }
    @Override 
    public void start(Stage stage) throws FileNotFoundException {
        String titleBg = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/space.png";
        Image titleScreen = new Image(titleBg, 1920,1080,false,true);
        //Image titleScreen = new Image(getClass().getResourceAsStream("space.jpg"));  
        String titleText = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/title.png";
        Image title = new Image(titleText, 777,174,false, true);
        String playURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/start.png";
        Image playButton = new Image(playURL,269,84,false,true);
        String exitURL = "https://raw.githubusercontent.com/Eliriah/Intergalactic_Assailants/master/exit.png";
        Image exitButton = new Image(exitURL, 267,82,false,true);

        ImageView imageView = new ImageView();
        imageView.setImage(titleScreen); 
        
        ImageView titleNode = new ImageView();
        titleNode.setImage(title);
        
        Button play_button  = new Button();
        ImageView playButtonNode = new ImageView();
        playButtonNode.setImage(playButton);
        play_button.setGraphic(playButtonNode);
        play_button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        //play_button.setOnAction()
        //howmst....
        
        Button exit_button  = new Button();
        ImageView exitButtonNode = new ImageView();
        exitButtonNode.setImage(exitButton); 
        exit_button.setGraphic(exitButtonNode);
        exit_button.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        exit_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent exit) {
                System.exit(0);
            }
        }
        );
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

        Pane root = new Pane();

        root.getChildren().addAll(imageView, titleNode, play_button, exit_button);
        Scene scene = new Scene(root, 1800, 1040); 
        stage.setTitle("Intergalactic Assailants");  
        stage.getIcons().add(new Image(GUI.class.getResourceAsStream("moon.png"))); 
        stage.setScene(scene);
        stage.show(); 
    }

}