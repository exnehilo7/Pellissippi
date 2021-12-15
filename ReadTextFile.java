/*
Programmer: Whomever created the project
Additional code by: Dan Hopp, 30-JAN-2020. The additional code will be commented
Description: Read up to 5 numbers from a text file named input.txt saved to the 
    project root directory. Print the numbers in the order as they appear in 
    the file.
*/

package lab02;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException; 

public class Hopp_Lab2
{
    public static final int SIZE = 5; //try changing to smaller than 5 (what new errors might you see?)          

    public static void main(String[] args) {
        double[] data;
        int index;
        Scanner input;

        data = new double[SIZE];
        index = 0;

        
        try {
            input = new Scanner(new File("input.txt"));
            
            while (input.hasNext()) {   

                //Adding a simple logic test. If the file has more items than 
                //the size of the array, alert the user and exit the loop
                if (index == SIZE) {
                    System.out.println("Alert! The text file can contain no "
                            + "greater than " + SIZE + " numbers.");
                    break;
                }

                data[index] = input.nextDouble();
                System.out.println(data[index]);
                index++;
            }
    
        }
        //Adding a try-catch for an unexpected missing file
        catch (FileNotFoundException ex1) {
            System.out.println("File not found! If the OS is Windows, is the "
                    + "file in the project root folder and named input.txt?");
        }
        //Adding a try-catch for any non-numeric characters in the file
        catch (InputMismatchException ex2) {
            System.out.println("Warning! The next character was not a "
                    + "number.");
        }   
        //Adding a catch-all as a backup, just in case for any unforseen 
        //exceptions
        catch (Exception ex3) {
            System.out.println("Warning! There was an unforseen exception!\n"
                    + ex3.toString() + "\nPlease contact your local dev to fix "
                    + " the issue.");
        }   
        //Adding a message so the user knows when the program reached its end
        System.out.println("End Program.");
    }
}
