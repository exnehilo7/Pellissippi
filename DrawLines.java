/*
 * Programmer: Dan Hopp
 * Date: 08-APR-2020
 * Description: This allows the user to draw lines using arrow keys.  
The drawing starts in the center of a pane. Arrow key presses will extend 
the line in the appropriate direction (left, right, up, down). The “amount”
of key pressing corresponds to how much is being drawn.

This uses a polyline, and the line stops at the edges of the window.
The polyline uses a list of coordinates, and there's a 2-block
array holding the current values of where the end of the line is at.
 */
package lab07;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Polyline;


public class Hopp_lab7a2 extends Application{
    
    //Main method
    public static void main(String[] args){
        Application.launch();
    }
    
    //Start Method
    @Override
    public void start(Stage PrimaryStage){
        
        //Make a blank pane
        Pane pane = new Pane();
        
        //Our friend, polyline
        Polyline pollyanna = new Polyline();
        pollyanna.setStroke(Color.BLACK);
        
        //List to hold polly's coords
        ObservableList<Double> pointList = pollyanna.getPoints();
        
        //Starting coords for the line, X and Y
        Double[] coords = {400.00, 400.00};
        pointList.add(coords[0]); //X
        pointList.add(coords[1]); //Y
        
        //Polly to pane
        pane.getChildren().add(pollyanna);
        
        //Add key event to the pane
        pane.setOnKeyPressed(e -> {
            drawLine(e.getCode(), pointList, coords);
        });

        //Show pane in scene
        Scene scene = new Scene(pane, 800, 800);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Etch-a-sketch");
        PrimaryStage.show();

        //pane is ready to recieve key inputs
        pane.requestFocus();
    }

    //Function to call drawLineSegment and pass which (X,Y) to alter and by how much.
    //Switch block for key type borrowed from Introduction to Java, 11th ed, Y. Liang
    private void drawLine(KeyCode code, ObservableList<Double> list, Double[] coords){
        
        switch (code) {
            case UP: //Alter -Y
                drawLineSegment(list, coords, 1, -10.0);
                break;
            case DOWN://Alter +Y
                drawLineSegment(list, coords, 1, 10.0);
                break;
            case LEFT://Alter -X
                drawLineSegment(list, coords, 0, -10.0);
                break;
            case RIGHT://Alter +X
                drawLineSegment(list, coords, 0, 10.0);
        }
        
    }

    //Updates the corrdinate array and calls functions to check if the line will go
    //past the window edge, and add the new corrdinates to the polyline's point list
    private void drawLineSegment(ObservableList<Double> list, 
            Double[] coords, int arrayIndex, double incrementValue){

        //Update array value
        coords[arrayIndex] = coords[arrayIndex] + incrementValue;

        //Has edge been reached?
        stopLineAtEdge(coords); 

        //Add (X,Y) to polyline
        list.add(coords[0]);
        list.add(coords[1]);
    }
    
    //Function to set line boundaries. If the added increment exceeded the limit,
    //reset the array value to the max/min value
    private void stopLineAtEdge(Double[] coords){
        
        if (coords[0] > 800.00)//X reached right edge?
            coords[0] = 800.00;
        else if (coords[1] > 800.00)//Y reached bottom edge?
            coords[1] = 800.00;
        else if (coords[0] < 0.00)//X reached left edge?
            coords[0] = 0.00;
        else if (coords[1] < 0.00)//Y reached top edge?
            coords[1] = 0.00;
    }
}
