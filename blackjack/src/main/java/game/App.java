package game;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;  

public class App extends Application {  
   @Override 
   public void start(Stage stage) throws FileNotFoundException {  
      Image[] cardarr = new Image[53];
      ImageView[] currentCards = new ImageView[53];
      setCardArray(cardarr);
      System.out.println(cardarr[2].getUrl());
      ImageView imageView;
      imageView = new ImageView(cardarr[0]);
      
      ImageView imageView2;
      imageView2 = new ImageView(cardarr[1]);

      ImageView imageView3;
      imageView3 = new ImageView(cardarr[2]);   
      
      currentCards[0] = imageView;
      currentCards[1] = imageView2;
      currentCards[2] = imageView3;
      //Setting the position of the image 
      imageView.setX(200); 
      imageView.setY(400); 
      
      //setting the fit height and width of the image view 
      imageView.setFitHeight(100); 
      imageView.setFitWidth(200); 
      
      //Setting the preserve ratio of the image view 
      imageView.setPreserveRatio(true);  
      
    /*************/
      imageView2.setX(300); 
      imageView2.setY(400); 
      
      //setting the fit height and width of the image view 
      imageView2.setFitHeight(100); 
      imageView2.setFitWidth(200); 
      
      //Setting the preserve ratio of the image view 
      imageView2.setPreserveRatio(true); 

      /*********/
      imageView3.setX(imageView.getX());
      imageView3.setY(imageView.getY());
      imageView3.setFitHeight(imageView.getFitHeight());
      imageView3.setFitWidth(imageView.getFitWidth());
      imageView3.setPreserveRatio(true);

      EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
         @Override 
         public void handle(MouseEvent e) { 
            imageView3.setX(50);
            imageView3.setY(500);
         } 
      };      
      EventHandler<MouseEvent> letGo = new EventHandler<MouseEvent>(){
         @Override
         public void handle(MouseEvent e){
            imageView3.setX(imageView.getX());
            imageView3.setY(imageView.getY());
         }
      };
      EventHandler<MouseEvent> HitButt = new EventHandler<MouseEvent>(){
         @Override
         public void handle(MouseEvent e){
            int x = (int)(Math.random() * 53);
            getImage(x, cardarr);
         }
      };

      imageView3.addEventFilter(MouseEvent.MOUSE_PRESSED, eventHandler);
      imageView3.addEventFilter(MouseEvent.MOUSE_RELEASED, letGo);
       
      Button hitButton;
      hitButton = new Button("hit");
      hitButton.setLayoutX(20);
      hitButton.setLayoutY(450);
      hitButton.setPrefSize(50, 20);
      hitButton.addEventFilter(MouseEvent.MOUSE_CLICKED, HitButt);

      //Creating a Group object  
      Group root = new Group(currentCards[0], currentCards[1], currentCards[2], hitButton);  
      //Creating a scene object 
      Scene scene = new Scene(root, 600, 500);  
      //Setting title to the Stage 
      stage.setTitle("Loading an image");  
      //Adding scene to the stage 
      stage.setScene(scene);

      scene.setFill(Color.GREEN);

      //Displaying the contents of the stage 
      stage.show(); 
   }  
   public static void main(String args[]) { 
      launch(args); 
   } 
   public Image getImage(int x, Image[] arr){
      return arr[x];
   }
   public Image[] setCardArray(Image[] arr){
      try {
         arr[0] = new Image(new FileInputStream("C:\\Users\\Dr3am\\VsCode projects\\JavaFxGame\\Images\\1.png")); 
         arr[1] = new Image(new FileInputStream("C:\\Users\\Dr3am\\VsCode projects\\JavaFxGame\\Images\\2.png"));
         arr[2] = new Image(new FileInputStream("C:\\Users\\Dr3am\\VsCode projects\\JavaFxGame\\Images\\3.png"));
      } catch (FileNotFoundException e) {
         System.out.println("File not found");
      }

      return arr;

   }
}