/*
 * Programmer: Dan Hopp
 * Date: 20-NOV-2019
 * Description:
    •	Create an array called salaryArray to store the hourly salary of 8 
        employees. Use the Math.random() method to randomly assign the hourly 
        salary to each employee. The salary should be in the range of $12.00 to 
        $75.00, inclusive. 
    •	Print contents of the salaryArray.
    •	Change the hourly salary to $55.00 for the employee with ID 5. 
    •	Print the salary and employee ID of the employee with the highest hourly
        salary.
    •	Print the salary and employee ID of the employee with the lowest hourly 
        salary.
    •	Print the difference between the highest and lowest hourly salaries.
    •	Assume that the national average for an hourly salary is $22.00. Print 
        the number of employees with an hourly salary higher than the national 
        average.

 */
package lab8;


public class Salary {
    public static void main(String[] args){
        
        //Create an array called salaryArray to store the hourly salary of 8 
        //employees
        double[] salaryArray = new double[8];
        
        //randomly assign hourly salary to each employee
        //$12.00 to $75.00, inclusive
        for(int i = 0; i < salaryArray.length; i++){
            salaryArray[i] = (Math.random() * 64) + 12;
        }
        
        //Print contents of the salaryArray
        System.out.println("The contents of salaryArray are:");
        for(int i = 0; i < salaryArray.length; i++){
            System.out.printf("$%4.2f ", salaryArray[i]);
        }
        //blank line
        System.out.println("\n");
        
        //Change the hourly salary to $55.00 for the employee with ID 5
        salaryArray[5] = 55.00;
        
        //Print the salary and employee ID of the employee with the highest 
        //hourly salary
        double highestSalary = salaryArray[0];
        int highestSalaryID = 0;
        for(int i = 1; i < salaryArray.length; i++){
            if(salaryArray[i] > highestSalary){
                highestSalary = salaryArray[i];
                highestSalaryID = i;
            }
        }
        System.out.printf("The highest salary is $%4.2f. The Employee ID is "
                + "%d.\n", highestSalary, highestSalaryID);
        
        //Print the salary and employee ID of the employee with the lowest 
        //hourly salary
        double lowestSalary = salaryArray[0];
        int lowestSalaryID = 0;
        for(int i = 1; i < salaryArray.length; i++){
            if(salaryArray[i] < lowestSalary){
                lowestSalary = salaryArray[i];
                lowestSalaryID = i;
            }
        }
        System.out.printf("The lowest salary is $%4.2f. The Employee ID is "
                + "%d.\n", lowestSalary, lowestSalaryID);
        
        
        //Print the difference between the highest and lowest hourly salaries
        System.out.printf("The difference between the highest and lowest " +
                "hourly salaries is $%4.2f.\n", (highestSalary - lowestSalary));
        
        //Assume that the national average for an hourly salary is $22.00. Print 
        //the number of employees with an hourly salary higher than the national 
        //average.
        int higherThanAverage = 0;
        for(int i = 0; i < salaryArray.length; i++){
            if(salaryArray[i] > 22.00){
                higherThanAverage++;
            }
        }
        System.out.println("The number of employees with an hourly salary " + 
                "higher than the national average of $22.00 is " + 
                higherThanAverage + ".");
        
    }
}
