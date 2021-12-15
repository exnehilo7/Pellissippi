/*
 * Programmer: Dan Hopp
 * Date: 09-APR-2020
 * Description: This has the following components and capabilities:

    •	A circle for a color display field.
    •	Four vertical scroll bars for:  Red, Green, Blue, Opacity.  
    •	The user can manipulate the look of the circle via 
        the GUI elements.
    •	Numeric values corresponding to the current scroll bar's state are 
        displayed below each bar and updates dynamically as the user 
        manipulates the corresponding GUI element.

The GUI elements will be stored in three arrays, one for each element. The 
indexes for the GUI arrays will be: 0=Red, 1=Green, 2=Blue, 3=Alpha.

To make the top of the scroll bar equal 100, the scroll bar's value is 
subtracted by 100 and then multiplied by -1. To change the circle's color, that
result is divided by 100 to get a double in the range of 0.0 - 1.0. For the 
opacity, value 0 

 */
package lab07;

import javafx.application.Application;
import static javafx.geometry.HPos.CENTER;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Hopp_lab7b1 extends Application{
    //Main method
    public static void main(String[] args) {
        Application.launch();
    }
    
    
    @Override
    public void start(Stage PrimaryStage){
        //Create HBox
        HBox hBox = new HBox(20);
        
        //Create GridPane for the GUI elements. It will have 3 rows and 4 columns
        GridPane grdPane = new GridPane();
        grdPane.setAlignment(Pos.CENTER);
        
        //Create circle. Default is visible white
        Circle circle = new Circle(125);
        circle.setFill(new Color(1, 1, 1, 1));
        
        //Create an array of scroll bars. 0=Red, 1=Green, 2=Blue, 3=Alpha
        ScrollBar[] sbArray = new ScrollBar[4];
        for (int i = 0; i < sbArray.length; i++){
            sbArray[i] = new ScrollBar();
            //Reorient
            sbArray[i].setOrientation(Orientation.VERTICAL);
            //Set heights
            sbArray[i].setPrefHeight(300);
            //Set thumb width
            sbArray[i].setVisibleAmount(20);
        }
        //Start Alpha at max (to the user it will be 0)
        //sbArray[3].setValue(100);
        
        //Create an array of labels for the scroll bars
        Label[] lblArray = new Label[4];
        for (int i = 0; i < lblArray.length; i++){
            lblArray[i] = new Label();
            lblArray[i].setFont(Font.font("System Regular", FontWeight.BOLD, 15));
        }
        //Set text strings
        lblArray[0].setText("Red");
        lblArray[1].setText("Green");
        lblArray[2].setText("Blue");
        lblArray[3].setText("Opacity");
        
        //Create an array of text fields
        TextField[] tfArray = new TextField[4];
        for (int i = 0; i < sbArray.length; i++){
            tfArray[i] = new TextField();
            //Set widths
            tfArray[i].setPrefColumnCount(3);
            tfArray[i].setAlignment(Pos.CENTER);
            //Set default display vaule
            tfArray[i].setText("100");
            //Read only
            tfArray[i].setEditable(false);
        }        

        //Place scroll bars, labels, and text fields in the grid pane
        for (int col = 0; col < 4; col++){
            //Labels
            grdPane.add(lblArray[col], col, 0);
            grdPane.setHalignment(lblArray[col], CENTER);
            //Scroll Bars
            grdPane.add(sbArray[col], col, 1);
            grdPane.setHalignment(sbArray[col], CENTER);
            //Text Fields
            grdPane.add(tfArray[col], col, 2);
        }
        
        //Place circle and grid pane in the hBox
        hBox.getChildren().addAll(circle, grdPane);
        hBox.setAlignment(Pos.CENTER);

        /*Tie the appropriate scroll bar to its text field:
         Call function to adjust scroll bar's value, then round the resulting 
         double to a long. Then call a function to update the circle's color.*/
        //Red
        sbArray[0].valueProperty().addListener(ov -> {
            tfArray[0].setText(Math.round(adjustScrollBarValue(sbArray, 0)) + "");
            setCircleColor(circle, sbArray);
        });
        //Green
        sbArray[1].valueProperty().addListener(ov -> {
            tfArray[1].setText(Math.round(adjustScrollBarValue(sbArray, 1)) + "");
            setCircleColor(circle, sbArray);
        });
        //Blue
        sbArray[2].valueProperty().addListener(ov -> {
            tfArray[2].setText(Math.round(adjustScrollBarValue(sbArray, 2)) + "");
            setCircleColor(circle, sbArray);
        });
        //Alpha
        sbArray[3].valueProperty().addListener(ov -> {
            tfArray[3].setText(Math.round(adjustScrollBarValue(sbArray, 3)) + "");
            setCircleColor(circle, sbArray);
        });
        
        //Show scene
        Scene scene = new Scene(hBox, 575, 350);
        PrimaryStage.setTitle("Color Sliders");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
    
    /*Set the circle's color by calling a function to adjust the scroll bar's value.
    Then divide the result by 100 to get a double in the range of 0.0 - 1.0.
    */
    private void setCircleColor(Circle circle, ScrollBar[] sbArray){
        //Red, Green, Blue, Alpha
        circle.setFill(new Color((adjustScrollBarValue(sbArray, 0) / 100),
            (adjustScrollBarValue(sbArray, 1) / 100), 
            (adjustScrollBarValue(sbArray, 2) / 100),
            (adjustScrollBarValue(sbArray, 3) / 100))); 

    }
    
    /*To make the top of the bar = 100, subtract the
    scroll bar's value by 100 and multiply by -1. */
    private double adjustScrollBarValue(ScrollBar[] sbArray, int arrayIndex){
        return ((sbArray[arrayIndex].getValue() - 100) * -1);
    }
}
