/*
 * Programmer: Dan Hopp
 * Date: 07-APR-2020
 * Description: This allows a user to create and remove points in a pane via 
    mouse clicks. The points wil be small circles. Left-clicking adds a point, 
    right-clicking within some particular circle (or on its edge) removes the
    point.
 */
package lab07;

import javafx.application.Application;
import javafx.scene.Scene;
import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class Hopp_lab7a1 extends Application{
    
    
    //Main method    
    public static void main(String[] args){
        
        Application.launch();
        
    }
    
    //Start module
    @Override
    public void start(Stage PrimaryStage){
        
        //Make blank canvas pane
        Pane pane = new Pane();
        
        //tie on-mouse-left-click event to the pane
        pane.setOnMouseClicked(e -> {
                     
            if(e.getButton() == PRIMARY){
                //Random color for the circle
                Color color = new Color(Math.random(), Math.random(), 
                    Math.random(), 1);
                //Create circle. Get x and y of mouse   
                Circle circle = new Circle(e.getX(), e.getY(), 25);
                circle.setFill(color);
                /*On right-click on the circle, delete/remove the circle object 
                from the pane */            
                circle.setOnMouseClicked(f -> {
                    if(f.getButton() == SECONDARY){
                        circle.setVisible(false);
                    } 
                });
                //add a circle to that location on the pane
                pane.getChildren().add(circle);
            }
        });
    
        //Display pane
        Scene scene = new Scene(pane, 700, 700);
        PrimaryStage.setTitle("Dippin' Dots");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
}
