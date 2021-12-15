/*
Date: 21-JAN-2020
Programmer: Dan Hopp
Description: Modify the program from Problem 1 to do the following:
    Prompt the user to enter two numbers (integers).
    Use these numbers instead of 5 and 6 in Problem 1. So for example, if the 
    user enters 11 and 38 your program should print out all numbers between 1 
    and 200 that are divisible by 11 OR 38 (but not both).
 */
package lab01;
import java.util.Scanner;


public class Hopp_prog2 {
    public static void main(String[] args){
    
        //Prompt the user to enter two numbers (integers)
        Scanner input = new Scanner(System.in);
        System.out.print("Please input two integers: ");
        int userInput1 = input.nextInt();
        int userInput2 = input.nextInt();

        //Print all numbers between 1 and 200 that are divisible by the two
        //integers the user submitted, but not divisible by both
        System.out.println("The following numbers between 1 and 200 are "
                + "divisible by " + userInput1 + " or by " + userInput2 +
            ", but not by both " + userInput1 + " AND " + userInput2 + ":");
        
        for(int i = 1; i <= 200 ; i++){
            if(i % userInput1 == 0 ^ i % userInput2 == 0){
                System.out.println(i);
            }
        }

    }
}
