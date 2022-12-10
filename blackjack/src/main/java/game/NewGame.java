package game;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewGame extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        EventHandler<MouseEvent> HitButt = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
               
            }
        };

        Button hit = new Button("hit");
        hit.setLayoutX(20);
        hit.setLayoutY(450);
        hit.setPrefSize(50, 20);
        hit.addEventFilter(MouseEvent.MOUSE_CLICKED, HitButt);

        Label number = new Label();
        number.setText("0");
        number.setPrefSize(1, 1);
        number.setLayoutX(250);
        number.setLayoutY(410);
        number.setFont(new Font("arial", 50));

        Rectangle cardBorder = new Rectangle(220, 400, 100, 200);
        cardBorder.setArcHeight(20);
        cardBorder.setArcWidth(20);
        cardBorder.setFill(Color.WHITE);
        //adding the things to the scene
        Group root = new Group(hit, cardBorder, number);
        Scene scene = new Scene(root, 600, 500);  
        //Setting title to the Stage 
        stage.setTitle("Loading an image");  
        //Adding scene to the stage 
        stage.setScene(scene);

        scene.setFill(Color.GREEN);

        //Displaying the contents of the stage 
        stage.show(); 
        
    }
}
