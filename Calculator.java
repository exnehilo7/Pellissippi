/*
 * Programmer: Dan Hopp
 * Date: 02-APR-2020
 * Description: Create a basic calculator. It should have the following 
    components (try to make it look nice and user-friendly):

    •	Three text fields. Two input fields, one output field.
    •	Four buttons:  Add, Subtract, Multiply, Divide

The functionality should be that of a standard calculator – appropriate 
arithmetic calculations should be performed upon button clicks.

The following input error checking will be performed prior to attempting to 
execute an arithmetic operation:

    •	Check that neither input is blank. If it is, do nothing, or display 
        any kind of a message to the user.
    •	Check that both inputs contain numbers. If non-numeric input is given, 
        display an error message to the user, stating that numeric input is 
        expected.

 */
package lab06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Calculator extends Application{
    
    Double dblOperand00;
    Double dblOperand01;
    
    @Override
    public void start(Stage PrimaryStage){
        //Create flow pane for text boxes and labels
        FlowPane fpTextIO = new FlowPane();
        fpTextIO.setHgap(10);
        
        TextField tfOperand00 = new TextField();
        TextField tfOperand01 = new TextField();
        TextField tfResult = new TextField();
        
        //Label for operator and message to the user
        Label lblOperator = new Label();
        Label lblMessage = new Label();
        lblMessage.setAlignment(Pos.CENTER);
        
        tfOperand00.setPrefColumnCount(10);
        tfOperand01.setPrefColumnCount(10);
        tfResult.setPrefColumnCount(10);
        
        fpTextIO.getChildren().addAll(new Label("Number1:"), tfOperand00,
                lblOperator, new Label("Number2:"), tfOperand01,
                new Label("   =   "), tfResult);
        
        
        //Create flow pane for buttons
        FlowPane fpButtons = new FlowPane();
        fpButtons.setHgap(10);
        
        Button btnAdd = new Button("  Add  ");
        Button btnSubtract = new Button("Subtract");
        Button btnMultiply = new Button("Multiply");
        Button btnDivide = new Button(" Divide ");
        
        fpButtons.getChildren().addAll(btnAdd, btnSubtract, btnMultiply, 
                btnDivide);
        fpButtons.setAlignment(Pos.CENTER);
        
        
      
        //Assign events to the buttons with the power of lambda  
        //Addition
        btnAdd.setOnAction(e -> {
            //If the data in the operands is valid, continue
            if(isValid(tfOperand00, tfOperand01, tfResult, lblMessage)){
                //Update variables
                setOperandValues(tfOperand00, tfOperand01);
                //Calculate result
                tfResult.setText((dblOperand00 + dblOperand01 + ""));
                //Update operator label
                setOperatorLabel(lblOperator, " + ");
            }
        });

        //Subtraction
        btnSubtract.setOnAction(e -> {
            if(isValid(tfOperand00, tfOperand01, tfResult, lblMessage)){
                setOperandValues(tfOperand00, tfOperand01);
                tfResult.setText((dblOperand00 - dblOperand01 + ""));
                setOperatorLabel(lblOperator, " - ");
            }
        });

        //Multiplication
        btnMultiply.setOnAction(e -> {
            if(isValid(tfOperand00, tfOperand01, tfResult, lblMessage)){
                setOperandValues(tfOperand00, tfOperand01);
                tfResult.setText((dblOperand00 * dblOperand01 + ""));
                setOperatorLabel(lblOperator, " * ");
            }    
        });        

        //Division
        btnDivide.setOnAction(e -> {
            if(isValid(tfOperand00, tfOperand01, tfResult, lblMessage)){
                setOperandValues(tfOperand00, tfOperand01);
                tfResult.setText((dblOperand00 / dblOperand01 + ""));
                setOperatorLabel(lblOperator, " / ");
            }
        });
        
        //Put text fields in center of a border pane
        BorderPane bdrPane = new BorderPane();
        bdrPane.setTop(fpTextIO);
        //Put the buttons on the bottom
        bdrPane.setBottom(fpButtons);
        //put the message in the mimddle
        bdrPane.setCenter(lblMessage);
        
        //Show scene and main stage
        Scene scene = new Scene(bdrPane, 750, 100);
        PrimaryStage.setTitle("Calculator");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
        
    }
    
    //Main method
    public static void main(String[] args){
        Application.launch(args);
    }
    
    //Method to populate the variables
    private void setOperandValues(TextField tfOperand00, TextField tfOperand01){
        dblOperand00 = Double.parseDouble(tfOperand00.getText());
        dblOperand01 = Double.parseDouble(tfOperand01.getText());
    }
    
    //Set the operator label with the specified symbol
    private void setOperatorLabel(Label lblOperator, String text){
        lblOperator.setText(text);
    }
    
    //Do the operands contain vaild values?
    private boolean isValid(TextField tfOperand00, TextField tfOperand01, 
            TextField tfResult, Label lblMessage){
        
        Boolean isValid = true;
        
        //Reset message and result text
        lblMessage.setText("");
        tfResult.setText("");
        
        
        //if operands are blank, do nothing
        if (tfOperand00.getText().length() < 1
                || tfOperand01.getText().length() < 1){
            isValid = false;
        }
        
        //if operands contain text, notify the user
        if (!tfOperand00.getText().matches("[0-9]*\\.{0,1}[0-9]*")
                || !tfOperand01.getText().matches("[0-9]*\\.{0,1}[0-9]*")){
            lblMessage.setText("Numeric input is expected!");
            isValid = false;
        }
        
        //Is there more than one decimal?
        if (getDecimalCount(tfOperand00.getText()) > 1
                || getDecimalCount(tfOperand01.getText()) > 1){
            lblMessage.setText("There are too many decimals!");
            isValid = false;
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
    
}
