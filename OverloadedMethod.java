/*
Date: 21-JAN-2020
Programmer: Dan Hopp
Description: Create two overloaded methods that return the average of data in 
    an array. Use the following headers:
        public static int average(int[] arr)
        public static double average(double[] arr)

    Invoke both, and print out the results.    

 */
package lab01;


public class Hopp_prog3 {
    public static void main(String[] args){
        //Create an array to pass to the integer method
        int[] intArray = {2, 4, 6, 8, 10};
        //Create an array to pass to the double method
        double[] doubleArray = {12.0, 14.0, 16.0, 18.0, 20.0};
        
        //Call the int method and print the result
        System.out.println("The integer average of the integer numbers 2, 4, 6" 
                + ", 8 and 10 is " + average(intArray) + ".");
        
        //Call the double method and print the result
        System.out.println("The double average of the double numbers 12.0, 14.0"
                + ", 16.0, 18.0 and 20.0 is " + average(doubleArray) + ".");
    }

    
    //Return the integer average in an integer array of numbers
    public static int average(int[] arr){
        //Declare variable for the sum
        int sum = 0;
        
        //Add the values in the array
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        
        //Compute and return the average
        return sum / arr.length;
    }
    
    //Return the double average in an double array of numbers
    public static double average(double[] arr){
        //Declare variable for the sum
        double sum = 0.0;
        
        //Add the values in the array
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        
        //Compute and return the average
        return sum / arr.length;
    }
}
    

