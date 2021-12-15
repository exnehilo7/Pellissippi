/*
 * Programmer: Dan Hopp
 * Date: 23-OCT-2019
 * Description: Prompt the user to enter three sides of a triangle. If the three
 * sides make a valid triangle, compute its area formatted to 2 decimal places.
 * If it's not a valid triangle, display that it is an invalid triangle.
 * Triangle area formula:
 *      s = (side1 + side2 + side3) / 2
 *      area = sqrt(s * (s - side1) * (s - side2) * (s - side3))
 *
 *
 * Use two methods.
 * #1 - Check if three sides will make a valid triangle:
 *          public static boolean isValidTriangle(double side1, double side2, 
 *              double side3)
 * #2 - If valid, a second method will compute the area of a triangle:
 *          public static double area(double side1, double side2, double side3)
 */
package lab6;
import java.util.Scanner;

public class Problem2 {
    
    public static void main(String[] arg) {

        //Prompt the user to enter three sides of a triangle
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three sides of the triangle as "
                + "double values: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        
        //Check for the valid triangle
        //if valid, give user the triangle's area
        if(isValidTriangle(side1, side2, side3)){
            
            //round to 2 decimal places
            System.out.printf("The area of the triangle is %4.2f\n",
                    area(side1, side2, side3));
            
        }
        //if invalid, let the user know
        else {
            System.out.println("The sides do not make a vaild triangle.");
        }
    }
    
    //return true if the sum of any two sides is greater than the third side
    public static boolean isValidTriangle(double side1, double side2, 
        double side3) {
        
        //check all "2 sides > third side" combos
        if (side1 + side2 > side3
                && side2 + side3 > side1
                && side1 + side3 > side2) {
            return true;
        }
        else {
            return false;
        }
    }
    
    //return the area of a triangle
    public static double area(double side1, double side2, double side3) {
        
        double s = (side1 + side2 + side3) / 2;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);  
        
    }
}
