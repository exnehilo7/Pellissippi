/*
 * Programmer: Dan Hopp
 * Date: 11-APR-2020
 * Description: This lets the user specify a (X,Y) coordinates of the top left 
corners of two rectangles, as well as their height and width. The button will
draw both rectangles in a display pane. At the bottom of the display pane, various
messages will appear. The display pane also has maximum and minimum coordinate
values to serve as a guide for the user. If the user enters values greater than
the limit, the numbers will auto adjust to the maximum size. Decimal entries on
all text fields will be roundned up.

Help for node collision detection was from:
https://www.oracle.com/technetwork/server-storage/ts-5280-159116.pdf
https://www.javaprogrammingforums.com/javafx/36342-javafx-collision-detection-simple.html

(A "does Rerctangle A's starting coordinates fall within Rectangle B's area" 
was first attempted. Knew there had to be some form of collision detection for 
a node within Java...)
 */
package lab07;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Hopp_lab7b2 extends Application{
    
    //Recangle drawing area dimensions
    double dblXMax = 600;
    double dblYMax = 600;
    
    //Declare GUI elements and panes
    Label lblInstructions = new Label("Enter the Rectangle Parameters");
    VBox vbGUIPane = new VBox(8);
    HBox hbRectACoordsX = new HBox(5);
    HBox hbRectACoordsY = new HBox(5);
    HBox hbRectADimns = new HBox(4);
    HBox hbRectBCoordsX = new HBox(5);
    HBox hbRectBCoordsY = new HBox(5);
    HBox hbRectBDimns = new HBox(4);
    HBox hbButton = new HBox();
    Pane pDrawPane = new Pane();
    HBox hbMainPane = new HBox();
     
    //Rectangle A
    Label lblRectAHeader = new Label("Rectangle A");
    Label lblRectAStartX = new Label("Top-Left Corner Starting X:");
    Label lblRectAStartY = new Label("Top-Left Corner Starting Y:");
    Label lblRectAWidth = new Label("Width:");
    Label lblRectAHeight = new Label("Height:");
    
    TextField tfRectAStartX = new TextField();
    TextField tfRectAStartY = new TextField();
    TextField tfRectAWidth = new TextField();
    TextField tfRectAHeight = new TextField();
    
    //Rectangle B
    Label lblRectBHeader = new Label("Rectangle B");
    Label lblRectBStartX = new Label("Top-Left Corner Starting X:");
    Label lblRectBStartY = new Label("Top-Left Corner Starting Y:");
    Label lblRectBWidth = new Label("Width:");
    Label lblRectBHeight = new Label("Height:");
    
    TextField tfRectBStartX = new TextField();
    TextField tfRectBStartY = new TextField();
    TextField tfRectBWidth = new TextField();
    TextField tfRectBHeight = new TextField();
    
    //Button, Coordinate Labels, and Message field
    Button btDrawRectangles = new Button("Draw Rectangles");
    Label lblBtmLftCoords = new Label("(0,0)");
    Label lblUprRghtCoords = new Label("(" + (int)dblXMax + "," + (int)dblYMax + ")");
    Label lblBtmRghtCoords = new Label("(" + (int)dblXMax + ",0)");
    Label lblUprLftCoords = new Label("(0," + (int)dblYMax + ")");
    Label lblMessages = new Label();
    Label lblBlankSpace00 = new Label();
    Label lblBlankSpace01 = new Label();
    Label lblBlankSpace02 = new Label();
    
    //Place text fields in an array
        TextField[] tfArray = {tfRectAStartX, tfRectAStartY, tfRectAWidth, 
            tfRectAHeight, tfRectBStartX, tfRectBStartY, tfRectBWidth,
            tfRectBHeight}; 
    
    //Main method
    public static void main(String[] args){
        Application.launch();
    }
    
    //Main function to display the GUI elements and the scene
    @Override
    public void start(Stage PrimaryStage){
        
        //Format labels & text fields and add to panes
        formatPaneAndGUIs();
        addGUIsToPanes();
        
        //Tie button and Enter key to Draw Rectangles
        btDrawRectangles.setOnAction(e -> {
            actionEvent();
        });
        hbMainPane.setOnKeyPressed(e -> {
            if (e.getCode() == ENTER){
                actionEvent();
            }
        });
        
        //Show scene
        Scene scene = new Scene(hbMainPane);
        PrimaryStage.setTitle("De Stijl");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
        
    }

    //Function for action event processing
    private void actionEvent(){
        
        //Reset message
        lblMessages.setText("");
        
        //Clear pane
        resetDrawingPane();
        
        //Is input valid?
        if (isValid()) {

            //Round values if user entered decimals
            for (TextField tf : tfArray){
                tf.setText(
                        roundInput(Double.parseDouble(tf.getText())) + ""
                );
            }

            //Draw
            drawRectangles();
            
        }
    }
    
    //Function to set the font, positioning, and size of the labels & text 
    //fields' text
    private void formatPaneAndGUIs(){
        
        //Draw Pane size & color
        pDrawPane.setPrefSize(dblXMax + 50, dblYMax + 20); //stretch a bit to include labels
        pDrawPane.setStyle("-fx-background-color: white;");
        
        //Text field widths
        for (TextField tf : tfArray){
            tf.setPrefColumnCount(4);
        }
        
        //HBox Paddings
        Insets insets = new Insets(0, 10, 0, 10); //T, R, B, L
        hbRectACoordsX.setPadding(insets);
        hbRectACoordsY.setPadding(insets);
        hbRectBCoordsX.setPadding(insets);
        hbRectBCoordsY.setPadding(insets);
        hbRectADimns.setPadding(insets);
        hbRectBDimns.setPadding(insets);
        
        //Label & Button Paddings
        lblInstructions.setPadding(new Insets(3, 5, 0, 5));
        vbGUIPane.setPadding(new Insets(0, 5, 0, 5));
        lblBlankSpace00.setPadding(new Insets(-10, 0, -10, 0));
        lblBlankSpace01.setPadding(new Insets(-5, 0, -5, 0));
        lblBlankSpace02.setPadding(new Insets(20, 0, 20, 0));
                
        //Button Pos
        hbButton.setAlignment(Pos.CENTER);
        
        //Label fonts
        lblInstructions.setFont(Font.font("System Regular", FontWeight.BOLD, 19));
        lblRectAHeader.setFont(Font.font("System Regular", 17));
        lblRectBHeader.setFont(Font.font("System Regular", 17));
        lblRectAHeader.setUnderline(true);
        lblRectBHeader.setUnderline(true);
        lblMessages.setFont(Font.font("System Regular", 17));
        lblBtmLftCoords.setFont(Font.font("System Regular", 12));
        lblUprRghtCoords.setFont(Font.font("System Regular", 12));
        lblBtmRghtCoords.setFont(Font.font("System Regular", 12));
        lblUprLftCoords.setFont(Font.font("System Regular", 12));
        
        //Label Pos
        lblBtmLftCoords.relocate(0,dblYMax); //Bottom left
        lblUprRghtCoords.relocate(dblXMax,0); //Top right
        lblBtmRghtCoords.relocate(dblXMax + 12,dblYMax); //Bottom right
        lblMessages.relocate(dblXMax * 0.3,dblYMax);  //Bottom center
        
        
    }
    
    //Function to reset drawing pane
    private void resetDrawingPane(){
        
        pDrawPane.getChildren().clear();
        addLabelsToDrawingPane();
        
    }
    
    private void addLabelsToDrawingPane(){
        pDrawPane.getChildren().addAll(lblBtmLftCoords, lblUprRghtCoords, 
                lblBtmRghtCoords, lblUprLftCoords, lblMessages);
    }
    
    //Function to add GUI elements to the panes
    private void addGUIsToPanes(){
        
        //Rectangle A (X,Y) to HBox
        hbRectACoordsX.getChildren().addAll(lblRectAStartX, tfRectAStartX);
        hbRectACoordsY.getChildren().addAll(lblRectAStartY, tfRectAStartY);
        
        //Rectangle B (X,Y) to HBox
        hbRectBCoordsX.getChildren().addAll(lblRectBStartX, tfRectBStartX); 
        hbRectBCoordsY.getChildren().addAll(lblRectBStartY, tfRectBStartY);
        
        //Rectangle A dimensions to HBox
        hbRectADimns.getChildren().addAll(lblRectAWidth, tfRectAWidth, 
                lblRectAHeight, tfRectAHeight);
        
        //Rectangle B dimensions to HBox
        hbRectBDimns.getChildren().addAll(lblRectBWidth, tfRectBWidth, 
                lblRectBHeight, tfRectBHeight);
        
        //Button to HBox
        hbButton.getChildren().addAll(btDrawRectangles);
        
        //Add HBoxes to GUI Pane
        vbGUIPane.getChildren().addAll(lblInstructions, lblBlankSpace00,
                lblRectAHeader, hbRectACoordsX, hbRectACoordsY,hbRectADimns,
                lblBlankSpace01,
                lblRectBHeader, hbRectBCoordsX, hbRectBCoordsY, hbRectBDimns,
                lblBlankSpace02,
                hbButton);
        
        //Add labels to Draw Pane
        addLabelsToDrawingPane();
        
        //Add the 2 panes to the Main Pane
        hbMainPane.getChildren().addAll(vbGUIPane, pDrawPane);
        
    }
    
    /*Function to draw the rectangles. If the X or Y value exceeds or is below 
    the drawing pane's limits, adjust the value. Also adjust the Y coord so high 
    values are at the top of the pane. Call doRectanglesIntersect. */
    private void drawRectangles(){
        
        //Are X and Y within bounds? If not, adjust text fields
        tfRectAStartX.setText(adjustUserInput(Long.parseLong(
                tfRectAStartX.getText())) + "");
        tfRectAStartY.setText(adjustUserInput(Long.parseLong(
                tfRectAStartY.getText())) + "");
        tfRectBStartX.setText(adjustUserInput(Long.parseLong(
                tfRectBStartX.getText())) + "");
        tfRectBStartY.setText(adjustUserInput(Long.parseLong(
                tfRectBStartY.getText())) + "");
        
        //Create rectangles and set their positions to their X,Y
        Rectangle rectangleA = new Rectangle(
                Double.parseDouble(tfRectAStartX.getText()), 
                adjustYCoord(Double.parseDouble(tfRectAStartY.getText())),
                Double.parseDouble(tfRectAWidth.getText()), 
                Double.parseDouble(tfRectAHeight.getText()));
        Rectangle rectangleB = new Rectangle(
                Double.parseDouble(tfRectBStartX.getText()), 
                adjustYCoord(Double.parseDouble(tfRectBStartY.getText())),
                Double.parseDouble(tfRectBWidth.getText()), 
                Double.parseDouble(tfRectBHeight.getText()));
        //Styles
        rectangleA.setFill(Color.TRANSPARENT);
        rectangleA.setStroke(Color.BLACK);
        rectangleB.setFill(Color.TRANSPARENT);
        rectangleB.setStroke(Color.BLACK);
        
        //add rectangles
        pDrawPane.getChildren().addAll(rectangleA, rectangleB);
        
        //Do they intersect?
        if(doRectanglesIntersect(rectangleA, rectangleB)){
            lblMessages.setText("The rectangles intersect."); 
        }
        
    }
    
    //Function to check if rectangles intersect
    private boolean doRectanglesIntersect(Rectangle rectangleA, Rectangle rectangleB){
        
        Boolean doRectsIntersct = false;
        
        if (rectangleA.getBoundsInParent().intersects(rectangleB.getBoundsInParent())){
            doRectsIntersct = true;
        }
        
        return doRectsIntersct;
    }
    
    
    //If the user enters a decimal, round to the nearest whole number
    private Long roundInput(Double value){
        return Math.round(value);
    }
    
    //Function to adjust text field values if starting X and Y exceed pane's boundary
    private Long adjustUserInput(Long value){
        
        Long temp;
        
        temp = value;
        
        if (value > dblXMax)//number is bigger then max size?
            temp = Math.round(dblXMax);
        else if (value < 0.00)//number is smaller than 0?
            temp = 0l;
        
        return temp;
    }
    
    //Function to verify user input
    private boolean isValid(){
        
        Boolean isValid = true;
        
        //if any text fields are blank, do nothing
        for (TextField tf : tfArray){
            if (tf.getText().length() < 1){
                isValid = false;
            }
        }
        
        //if text fields contain text, notify the user
        for (TextField tf : tfArray){
            if (!tf.getText().matches("[0-9]*\\.{0,1}[0-9]*")){
                lblMessages.setText("Positive numeric input is expected!");
                isValid = false;
            }
        }
        
        //Is there more than one decimal?
        for (TextField tf : tfArray){
            if (getDecimalCount(tf.getText()) > 1)
            {
                lblMessages.setText("There are too many decimals!");
                isValid = false;
            }
        }
        
        return isValid;
    }
    
    //Function to count .'s
    private Integer getDecimalCount(String text){
        
        Character temp;
        int count = 0;  
        
        for (int i = 0; i < text.length(); i++){
            temp = text.charAt(i);
            if (temp == '.'){
                count++;
            }
        }
        return count;
    }
    
    //Function to adjust Y so 0 is at the bottom of the pane
    private double adjustYCoord(Double value){
           return ((value - dblYMax) * -1);
    }
    
}
