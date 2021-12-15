/*
 * Programmer: Dan Hopp
 * Date: 20-SEP-2019
 * Description: Ask the user for their plumbing service charges, and if they are
 * a new or exsting customer. Calculate and display the customer type, service 
 * charges, discount amount, and the final charges, using the following table:
 *
 * Discount         Service Charge  Disc for    Disc for
 * Category                         Existing    New
 * -----------------------------------------------------
 * 1                $69-149         -           -           
 * 2                $150-249        5%          -
 * 3                $250-499        8%          4%
 * 4                $500+           10%         6%
 * 
 * If the user enters less than $69, display "Invalid service charge amount"
 * If the user enters an invalid customer type, display "Invalid customer type"
 */

package lab3;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] arg) {

        //Declare discount constants
        final double CAT2_EXISTING_DISC = 0.05;
        final double CAT3_EXISTING_DISC = 0.08;
        final double CAT3_NEW_DISC = 0.04;
        final double CAT4_EXISTING_DISC = 0.10;
        final double CAT4_NEW_DISC = 0.06;
        
        //Prompt the user if they are a new or exsting customer
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the customer type (0 for existing, "
                + "1 for new): ");
        int customer = input.nextInt();
        
        //Check for invalid customer type. If not, assign customer type to a 
        //variable. Existing = 0   New = 1
        String customerType = ""; //<=== to be honest I had to look that one up
         
        switch (customer) {
            case 0:
                customerType = "Existing";
                break;
            case 1:
                customerType = "New";
                break;
            default:
                System.out.println("Invalid customer type.");
                System.exit(0);  //had to look this one up too           
        }
        
        //Prompt the user for their plumbing service charges
        System.out.print("Enter the charges for the plumbing service: $");
        double charges = input.nextDouble();     
        
        //Set percentage variable to 0 and get the discount percentage based on 
        //charges and discount category
        double discountPercentage = 0;
        
        if (charges < 69) {
            System.out.println("Invalid service charge amount.");
            System.exit(0);
        }
        else if (charges < 150) {               
            //no discount applied
        }
        else if (charges < 250) {
            discountPercentage = (customer == 0) ? CAT2_EXISTING_DISC : 0;
        }
        else if (charges < 500) {
            discountPercentage = (customer == 0) ? CAT3_EXISTING_DISC 
                    : CAT3_NEW_DISC;
        }
        else {
            discountPercentage = (customer == 0) ? CAT4_EXISTING_DISC 
                    : CAT4_NEW_DISC; 
        }
        
        //Calculate the discount amount and final charges
        double discountAmount = charges  * discountPercentage;
        double finalCharges = charges - discountAmount;
        
        //Display the customer type, service charges, discount amount, and the 
        //final charges
        System.out.println("Customer Type: " + customerType);
        System.out.println("Plumbing service charges: $" + 
                (int)(charges * 100 + 0.5) / 100.0);
        System.out.println("Discount Amount: $" + 
                (int)(discountAmount * 100 + 0.5) / 100.0);
        System.out.println("Total amount due: $" + 
                (int)(finalCharges * 100) / 100.0);
        
    }
}
