/*
 * Programmer: Dan Hopp
 * Date: 13-OCT-2019
 * Description: Prompt the user to enter an interger number. Use a RNG to
 * generate user-specified integers from 1 to 10 inclusive. Determine:
 *      The string of generated integers
 *      Number of even integers
 *      Number of odd integers
 *      Largest integer
 *      Average of the even integers, display with 2-digit precision
 *      Average of the odd integers, display with 2-digit precision
 */

package lab5;
import java.util.Scanner;

public class Problem1 {
    
    public static void main(String[] arg) {
        
        //declare variables
        String numberString = "";
        int oddCount = 0, evenCount = 0, largestInteger = 0;
        double oddTotal = 0, evenTotal = 0, oddAverage = 0, evenAverage = 0;
        
        //Prompt the user for interger
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of integers: ");
        int usersInteger = input.nextInt();
        
        //Generate user-specified integers from 1 to 10 inclusive and do
        //the maths
        while (usersInteger > 0) {
            //generate integer
            int tempRng = (int)(Math.random() * 10) + 1;
            
            //add to the string of integers
            numberString = numberString + tempRng + " ";
            
            //determine if integer is even
            if (tempRng % 2 == 0) {
            //add to even number's Count and sum even value(s)
                evenCount++;
                evenTotal = evenTotal + tempRng;
            }
            //else add to odd numbers's Count and sum odd value(s)
            else {
                oddCount++;
                oddTotal = oddTotal + tempRng;                
            }
            
            //find largest integer
            if (tempRng > largestInteger) {
                largestInteger = tempRng;
            }
            
            //tick down loopcount
            usersInteger--;
        }
        
        //calculate even average. Ignore if evenCount = 0;
        if (evenCount > 0) {
            evenAverage = evenTotal / evenCount;
        }
        
        //calculate odd average. Ignore if oddCount = 0;       
        if (oddCount > 0) {
            oddAverage = oddTotal / oddCount;
        }
        
        //display results
        //If user entered  > 1, display thier number
        if (numberString.length() > 0) {
            //trim for easier line selection
            System.out.println(numberString.trim()); 
        }
        else {
            System.out.println(usersInteger + " is an invalid number.");
        }
        System.out.println("Number of even integers: " + evenCount);
        System.out.println("Number of odd integers: " + oddCount);
        System.out.println("The largest integer: " + largestInteger);
        System.out.printf("Average of even integers: %-3.2f\n", evenAverage);
        System.out.printf("Average of odd integers: %-3.2f\n", oddAverage);
        
    }
}
