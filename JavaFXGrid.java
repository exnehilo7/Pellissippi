/*
Programmer: Dan Hopp
Date: 05-MAR-2020
Description: Implement the following in one JavaFx application file (one 
application/file, but make it create two stages):

    Stage 1:  Display a 10x10 grid of buttons with no labels. Buttons should
              all be of same size, centered neatly in a grid pattern,
              using a nested loop for the button placement.

    Stage 2:  Display a 10x10 grid of randomly-generated 0’s and 1’s. Each 
              number should be centered in a text field, using TextField’s 
              setText() method.

 */
package gridclick;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Hopp_lab5a extends Application{
    @Override
    public void start(Stage primaryStage){
        

        //Show the first stage
        primaryStage.setTitle("Stage 1");
        //Populate with buttons
        primaryStage.setScene(createGridOfButtons());
        primaryStage.show();
        
        //Set stage for Stage 2
        Stage stage02 = new Stage();
        //Show the second stage
        stage02.setTitle("Stage 2");
        //Populate with text fields with a random 1 or 0
        stage02.setScene(createGridOfTextFields());
        stage02.show();
        
    }
    
    
    //10x10 grid of buttons with no labels
    private Scene createGridOfButtons(){
        //Create a grid pane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        
        
        //Create an array of buttons
        Button[] btArray = new Button[100];
        for (int i = 0; i < btArray.length; i++){
            btArray[i] = new Button("  "); //Adding space to make the buttons more square
        }
        
        //Add some buttons
        //go down the line of rows
        int arrIndex = 0; //Button #
        for (int row = 0; row < 10; row++){
            //Populate the row with buttons
            for (int col = 0; col < 10; col++){
                gridPane.add(btArray[arrIndex], col, row);
                arrIndex++;
            }
        }
        
        //Make a scene to put in the main stage
        Scene scene = new Scene(gridPane);
        
        return scene;
    }
    
    
    //10x10 grid of randomly-generated 0’s and 1’s
    private Scene createGridOfTextFields(){
    //Create a grid pane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        
        
        //Create an array of text fields
        TextField[] tfArray = new TextField[100];
        for (int i = 0; i < tfArray.length; i++){
            tfArray[i] = new TextField();
            //Set text field size to make the fields more square
            tfArray[i].setPrefColumnCount(1);
        }
        
        //Add the text fields to the grid
        //go down the line of rows
        int i = 0; //Button #
        for (int row = 0; row < 10; row++){
            //Populate the row with buttons
            for (int col = 0; col < 10; col++){
                gridPane.add(tfArray[i], col, row);
                //Populate with a 1 or 0
                tfArray[i].setText(((int)(Math.random() * 2)) + "");
                //Align text to center
                tfArray[i].setAlignment(Pos.CENTER);
//                //Set width to make it look a little better
//                tfArray[i].setColumns();
                i++;
            }
        }

        //Make a scene to put it in the second stage
        Scene scene = new Scene(gridPane);    
        
        return scene;
    }
    
    //Launch app
    public static void main(String[] args){
        Application.launch(args);
    }
}
