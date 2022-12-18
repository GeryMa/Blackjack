package game;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewGame extends Application{
    final int Y = 400;
    int x = 120;
    int totalAmt = 0;
    public static void main(String[] args){
        launch(args);
    }
    public void begin(ArrayList<Integer> posCards, ArrayList<Integer> posSuite){
        Group root3 = new Group();
        EventHandler<MouseEvent> HitButt = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                root3.getChildren().add(drawCard(x, posCards, posSuite));
            }
        };
        
        Button hit = new Button("hit");
        hit.setLayoutX(20);
        hit.setLayoutY(450);
        hit.setPrefSize(50, 20);
        hit.addEventFilter(MouseEvent.MOUSE_CLICKED, HitButt);

        int num = (int)(Math.random() * posCards.size());
        if(posCards.get(num) != 11){
            addTotal(posCards.get(num));
        }
        Label number = new Label();
        if(posCards.get(num) == 11){
            aceOption(number, x);
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

        
        root3.getChildren().add(hit);
        root3.getChildren().add(cardBorder);
        root3.getChildren().add(number);
        root3.getChildren().add(card2);


        switch(posSuite.get(num)){
            case(1):
                root3.getChildren().add(drawHeart(x+10, 415));
                break;
            case(2):
                root3.getChildren().add(drawDiamond(x+10, 415));
                break;
            case(3):
                root3.getChildren().add(drawSpade(x+10, 415));
                break;
            case(4):
                root3.getChildren().add(drawClove(x+10, 415));
                break;
        }

        posCards.remove(num);
        posSuite.remove(num);
       

        num = (int)(Math.random() * posCards.size());
        if(posCards.get(num) != 11){
            addTotal(posCards.get(num));
        }
   
        x += 120;
        Label secondNum = new Label();
        if(posCards.get(num) == 11){
            aceOption(secondNum , x);
        }else{
            secondNum.setText("" + posCards.get(num));
        }
        secondNum.setPrefSize(80,80);
        secondNum.setLayoutX(x+30);
        secondNum.setLayoutY(Y+10);
        secondNum.setFont(new Font("arial", 50));
        root3.getChildren().add(secondNum);
        switch(posSuite.get(num)){
            case(1):
                root3.getChildren().add(drawHeart(x+10, 415));
                break;
            case(2):
                root3.getChildren().add(drawDiamond(x+10, 415));
                break;
            case(3):
                root3.getChildren().add(drawSpade(x+10, 415));
                break;
            case(4):
                root3.getChildren().add(drawClove(x+10, 415));
                break;
        }     
        posCards.remove(num);
        posSuite.remove(num);
        root2.getChildren().add(root3);
    }
    public void updateX(int x){
        this.x = x;
    }
    public void addTotal(int x){
        totalAmt = totalAmt + x;
    }
    public int getTotal(){
        return totalAmt;
    }

    public void compareToDealer(int x){
        Group resultBox = new Group();
        int dealerScore = (int)(Math.random() * (27 - 13) + 13);
        System.out.println(dealerScore);
        System.out.println(x);
        Rectangle box = new Rectangle(100, 100, 400, 200);
        resultBox.getChildren().add(box);
        if(dealerScore > 21 && x > 21){ 
            Label text = new Label("You both went over, you lose");
            text.setFont(new Font("Arial", 30));
            text.setTextFill(Color.WHITE);
            text.setLayoutX(120);
            text.setLayoutY(120);
            resultBox.getChildren().add(text);
        }else if(dealerScore > 21 && x <= 21){
            Label text = new Label("Dealer went over. You win");
            text.setFont(new Font("Arial", 30));
            text.setTextFill(Color.WHITE);
            text.setLayoutX(120);
            text.setLayoutY(120);
            resultBox.getChildren().add(text);
        }else if(dealerScore <= 21 & x > 21){
            Label text = new Label("you bust. dealer wins");
            text.setFont(new Font("Arial", 30));
            text.setTextFill(Color.WHITE);
            text.setLayoutX(120);
            text.setLayoutY(120);
            resultBox.getChildren().add(text);
        }else if(dealerScore <= 21 && x <= 21 && dealerScore < x){
            Label text = new Label("you beat the dealer, you win");
            text.setFont(new Font("Arial", 30));
            text.setTextFill(Color.WHITE);
            text.setLayoutX(120);
            text.setLayoutY(120);
            resultBox.getChildren().add(text);
        }else if(dealerScore <= 21 && x <= 21 && dealerScore > x){
            Label text = new Label("Dealer won");
            text.setFont(new Font("Arial", 30));
            text.setTextFill(Color.WHITE);
            text.setLayoutX(120);
            text.setLayoutY(120);
            resultBox.getChildren().add(text);
        }else{
            Label text = new Label("i dunno what happened. you lose");
            text.setFont(new Font("Arial", 30));
            text.setTextFill(Color.WHITE);
            text.setLayoutX(120);
            text.setLayoutY(120);
            resultBox.getChildren().add(text);
        }
        root2.getChildren().add(resultBox);
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
    
    public Group drawCard(int x, ArrayList<Integer> posCards, ArrayList<Integer> posSuite){
        Group cardMake = new Group();
        x+= 120;
        Rectangle card = new Rectangle(x, Y, 100, 200);
        card.setArcHeight(20);
        card.setArcWidth(20);
        card.setFill(Color.WHITE);
        cardMake.getChildren().add(card);
        int num = (int)(Math.random() * posCards.size());
                
        switch(posSuite.get(num)){
            case(1):
                cardMake.getChildren().add(drawHeart(x+10, 415));
                break;
            case(2):
                cardMake.getChildren().add(drawDiamond(x+10, 415));
                break;
            case(3):
                cardMake.getChildren().add(drawSpade(x+10, 415));
                break;
            case(4):
                cardMake.getChildren().add(drawClove(x+10, 415));
                break;
        }
        if(posCards.get(num) != 11){
            addTotal(posCards.get(num));
        }
        System.out.println(posCards.get(num));
        posCards.remove(num);
        posSuite.remove(num);
        Label secondNum = new Label();
        if(posCards.get(num) == 11){
            aceOption(secondNum , x);
        }else{
            secondNum.setText("" + posCards.get(num));
        }
        secondNum.setPrefSize(80,80);
        secondNum.setLayoutX(x+30);
        secondNum.setLayoutY(Y+10);
        secondNum.setFont(new Font("arial", 50));
        cardMake.getChildren().add(secondNum);

        updateX(x);
        return cardMake;
    }
    
    public void aceOption(Label y, int x){
        Group tester = new Group();
        String option = "";
        Label words = new Label("Choose between 1 or 11");
        EventHandler<MouseEvent> ONE = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
               y.setText("1");
               addTotal(1);
               tester.getChildren().clear();
            }
        };
        EventHandler<MouseEvent>ELEVEN = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                y.setText("11");
                addTotal(11);
                tester.getChildren().clear();
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
        tester.getChildren().add(words);
        tester.getChildren().add(one);
        tester.getChildren().add(eleven);
        root2.getChildren().add(tester);
    }
    @Override
    public void start(Stage stage) throws Exception {
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
        

        begin(posCards, posSuite);
        

        EventHandler<MouseEvent> calculateScore = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                compareToDealer(getTotal());
            }
        };

        Button finish = new Button("end turn");
        finish.setLayoutX(20);
        finish.setLayoutY(400);
        finish.setPrefSize(50, 20);
        finish.addEventFilter(MouseEvent.MOUSE_CLICKED, calculateScore);
        root2.getChildren().add(finish);
        
        //adding the things to the scene
        Group root = new Group(root2);
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
