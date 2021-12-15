/*
 * Programmer: Dan Hopp
 * Date: 29-SEP-2019
 * Description: Prompt the user to enter a hexadecimal number of exactly two
 * hex characters. Compute and display the value in decimal. Check for invalid
 * input characters and invalid input length (Only valid is 2)
 */
package lab4;
import java.util.Scanner;

public class Problem2 {
    
    public static void main(String[] arg) {

        //Declare variables
        int charValue1 = 0;
        int charValue2 = 0;

        //Prompt user for input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a two character hex number: ");
        String hexString = input.nextLine();

        //Validate if string is only 2 in length
        if (hexString.length() != 2) {
            System.out.println("Please enter exactly two hex characters.");
            System.exit(0);
        }

        //Check for invalid hex characters on 1st char. Adjust its ASCII value
        //to the actual numerical value
        char ch1 = Character.toUpperCase(hexString.charAt(0));
        if (ch1 >= 'A' && ch1 <= 'F') {
            charValue1 = ch1 - 'A' + 10;
        } else if (Character.isDigit(ch1)) {
            charValue1 = ch1 - '0';
        } else {
            System.out.println(ch1 + " is an invalid hex character.");
            System.exit(0);
        }

        //Check for invalid hex characters on the 2nd char. Adjust its ASCII 
        //value to the actual numerical value
        char ch2 = Character.toUpperCase(hexString.charAt(1));
        if (ch2 >= 'A' && ch2 <= 'F') {
            charValue2 = ch2 - 'A' + 10;
        } else if (Character.isDigit(ch2)) {
            charValue2 = ch2 - '0';
        } else {
            System.out.println(ch2 + " is an invalid hex character.");
            System.exit(0);
        }

        //Add the two numerical values and adjust 1st character's value to its 
        //16^1 number place
        int decimalNumber = (charValue1 * 16) + charValue2;

        //Display the results 
        System.out.println("The decimal equivalent of the hex value " + ch1
                + ch2 + " is " + decimalNumber);

    }

}
