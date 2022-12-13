package game;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewGame extends Application{
    final int Y = 400;
    int x = 150;
    public static void main(String[] args){
        launch(args);
    }
    Group root2 = new Group();
    public Group drawHeart(int x, int y){
        Group test = new Group();
        Rectangle rect = new Rectangle(x, y, 15, 15);
        rect.setRotate(45);
        Circle circle1 = new Circle(x, y+1, 7);
        Circle circle2 = new Circle(x + 15, y+1 , 7);
        rect.setFill(Color.RED);
        circle1.setFill(Color.RED);
        circle2.setFill(Color.RED);
        test.getChildren().add(rect);
        test.getChildren().add(circle1);
        test.getChildren().add(circle2);
        return test;
    }
    
    public Group drawDiamond(int x, int y){
        Group test = new Group();
        Rectangle rect = new Rectangle(x, y, 12, 12);
        rect.setRotate(45);
        rect.setFill(Color.RED);
        test.getChildren().add(rect);
        return test;
    }
    public Group drawClove(int x, int y){
        Group test = new Group();
        Circle leftCirc = new Circle(x-1, y, 5);
        leftCirc.setFill(Color.BLACK);
        Circle rightCirc = new Circle(x + 5, y, 5);
        rightCirc.setFill(Color.BLACK);
        Circle topCirc = new Circle(x + 2, y - 5, 5);
        topCirc.setFill(Color.BLACK);
        Rectangle base = new Rectangle(x - 4, y + 2, 10, 5);
        base.setRotate(90);
        test.getChildren().add(leftCirc);
        test.getChildren().add(rightCirc);
        test.getChildren().add(topCirc);
        test.getChildren().add(base);
        
        return test;
    }
    public Group drawSpade(int x, int y){
        Group test = new Group();
        Circle leftCirc = new Circle(x,y, 6);
        Circle rightCirc = new Circle(x+7, y, 6);
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
            (double)x+3, (double)y-15,
            (double)x-5, (double)y+3,
            (double)x+12, (double)y+3
        );
        Rectangle base = new Rectangle(x, y, 5, 10);
        //base.setRotate(90);
        test.getChildren().add(leftCirc);
        test.getChildren().add(rightCirc);
        test.getChildren().add(triangle);
        test.getChildren().add(base);
        return test;
    }
    public Group drawCard(){
        Group cardMake = new Group();

        return cardMake;
    }
    
    public void aceOption(Label y){
        String option = "";
        Label words = new Label("Choose between 1 or 11");
        EventHandler<MouseEvent> ONE = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
               y.setText("1");
            }
        };
        EventHandler<MouseEvent>ELEVEN = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                y.setText("11");
            }
        };
        Button one = new Button("1");
        Button eleven = new Button("11");
        one.setLayoutX(x+55);
        one.setLayoutY(Y-25);
        one.setPrefSize(30, 20);

        eleven.setLayoutX(x+15);
        eleven.setLayoutY(Y-25);
        eleven.setPrefSize(30, 20);

        words.setLayoutX(x);
        words.setLayoutY(Y-50);

        one.addEventFilter(MouseEvent.MOUSE_CLICKED, ONE);
        eleven.addEventFilter(MouseEvent.MOUSE_CLICKED, ELEVEN);
        root2.getChildren().add(words);
        root2.getChildren().add(one);
        root2.getChildren().add(eleven);
    }
    @Override
    public void start(Stage stage) throws Exception {
        EventHandler<MouseEvent> HitButt = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                root2.getChildren().add(drawCard());
            }
        };
        ArrayList<Integer> posCards = new ArrayList<Integer>();
        for(int i = 2; i < 12; i++){
            for(int j = 0; j < 4; j++){
                posCards.add(i);
            }
        }
        ArrayList<Integer> posSuite = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            for(int j = 1; j < 5; j++){
                posSuite.add(j);
            }
        }
        Button hit = new Button("hit");
        hit.setLayoutX(20);
        hit.setLayoutY(450);
        hit.setPrefSize(50, 20);
        hit.addEventFilter(MouseEvent.MOUSE_CLICKED, HitButt);

        
        
        int num = (int)(Math.random() * 40);
        num = 39;
        for(int i = 0; i < posCards.size(); i++){
            if(posCards.get(i) == num){
                posCards.remove(i);
                posSuite.remove(i);
            }
        }
        switch(posSuite.get(num)){
            case(1):
                root2.getChildren().add(drawHeart(x+10, 415));
                break;
            case(2):
                root2.getChildren().add(drawDiamond(x+10, 415));
                break;
            case(3):
                root2.getChildren().add(drawSpade(x+10, 415));
                break;
            case(4):
                root2.getChildren().add(drawClove(x+10, 415));
                break;
        }
        Label number = new Label();
        if(posCards.get(num) == 11){
            aceOption(number);
        }else{
            number.setText("" + posCards.get(num));
        }
        number.setPrefSize(80, 80);
        number.setLayoutX(x+30);
        number.setLayoutY(Y+10);
        number.setFont(new Font("arial", 50));

        Rectangle cardBorder = new Rectangle(x, Y, 100, 200);
        cardBorder.setArcHeight(20);
        cardBorder.setArcWidth(20);
        cardBorder.setFill(Color.WHITE);

        Rectangle card2 = new Rectangle(x + 120, Y, 100, 200);
        card2.setArcHeight(20);
        card2.setArcWidth(20);
        card2.setFill(Color.WHITE);

        Group root3 = new Group(hit, cardBorder, number, card2);
        
        //adding the things to the scene
        Group root = new Group(root3, root2);
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
