/*
 * Programmer: Dan Hopp
 * Date: 20-NOV-2019
 * Description:
    •	Take user input for the hourly salaries of 10 employees. 
    •	Use the methods defined in the Salary class to print the hourly salary 
        of all employees, average salary, highest salary, lowest salary, and the
        number of employees with the below-average salary. 

 */
package lab8;
import java.util.Scanner;

public class HourlySalaryTest {
    public static void main(String[] args) {
        //create array
        double[] salaries = new double[10];
        //create class instance
        HourlySalary hs = new HourlySalary();
        
        //Take user input for the hourly salaries of 10 employees
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter 10 hourly salaries: ");
        for(int i = 0; i < salaries.length; i++){
            salaries[i] = input.nextDouble();
        }
        //blank line
        System.out.println();
        
        //Use the methods defined in the Salary class:
        //print the hourly salary of all employees
        HourlySalary.printSalary(salaries);
        
       //blank line
       System.out.println();
       //print average salary
       double salaryAverage = hs.averageSalary(salaries);
       System.out.printf("The average hourly salary is $%4.2f.\n", 
               salaryAverage);
       
       //print highest salary
       hs.highestSalary(salaries);
       
       //print lowest salary
       hs.lowestSalary(salaries);
       
       //print number of employees with below-average salary
       System.out.println("The number of employees with less than the average" + 
               " hourly salary is " + 
               hs.belowAverageSalary(salaries, salaryAverage) + 
               ".");
    }
}
