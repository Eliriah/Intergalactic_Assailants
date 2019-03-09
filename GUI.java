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
import javafx.scene.layout.StackPane;
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
        Image titleScreen = new Image(getClass().getResourceAsStream("space.jpg"));  
        Image title = new Image("images/title.png");
        Image playButton = new Image("images/start.png");
        Image exitButton = new Image("images/exit.png");

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
        imageView.setX(0); 
        imageView.setY(0); 
        imageView.setFitHeight(1080); 
        imageView.setFitWidth(1300); 
        imageView.setPreserveRatio(true);  
        //this sht VVV isnt moving for some reason >:(((
        titleNode.setX(1000);
        titleNode.setY(1000);

        final VBox buttons = new VBox();

        
        Insets buttonPadding = new Insets(1375,1000,1000,1000);
        buttons.setPadding(buttonPadding);
        buttons.getChildren().addAll(play_button, exit_button);
        StackPane root = new StackPane();

        root.getChildren().addAll(imageView, titleNode, buttons);
        Scene scene = new Scene(root, 1800, 1040); 
        stage.setTitle("Intergalactic Assailants");  
        stage.getIcons().add(new Image(GUI.class.getResourceAsStream("moon.png"))); 
        stage.setScene(scene);
        stage.show(); 
    }

}