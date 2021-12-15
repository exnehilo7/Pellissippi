/*
 * Programmer: Dan Hopp
 * Date: 11-OCT-2019
 * Description: Display two tables side by side. The left table will convert 
 * will convert meters from feet, starting at 7m and ending at 107m. The right
 * table will convert feet to meters, starting at 50ft and ending at 150ft.
 * Display conversions with 2 decimal points
 * 1m = 3.2808ft. 1ft = 0.3048m.
 */

package lab5;


public class Problem2 {
    
    public static void main(String[] arg) {
        
        //declare constants
        final double METERS_TO_FEET = 3.2808;
        final double FEET_TO_METERS = 0.3048;
        
        //print table header
        System.out.printf("%-10s%-10s%-5s%-10s%-10s\n", "Meters", "Feet", "|",
                "Feet", "Meters");
        
        //set measurement lengths and iterate loop 10 times
        for (int meters = 7, feet = 50; meters < 108; 
                meters += 10, feet += 10) {
            //convert measurements and print table line
            System.out.printf("%-10d%-10.2f%-5s%-10d%-10.2f\n", meters, 
                    (meters * METERS_TO_FEET), "|", feet,
                    (feet * FEET_TO_METERS));  
        }
        
    }
}
