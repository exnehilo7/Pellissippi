/*
 * Programmer: Dan Hopp
 * Date: 20-NOV-2019
 * Description:
    •	Define a static method called printSalary to print hourly salaries. The 
        printSalary method should take a double array as an input.
    •	Define an instance method called averageSalary to return average hourly 
        salary.
    •	Define an instance method called highestSalary to print the highest 
        hourly salary.
    •	Define an instance method called lowestSalary to print the lowest hourly
        salary.
    •	Define an instance method called belowAverageSalary to return the number
        of employees with less than the average hourly salary.

 */
package lab8;


public class HourlySalary {
    //default constructor
    public HourlySalary(){
        
    }
    //Static method called printSalary to print hourly salaries. The 
    //printSalary method should take a double array as an input.
    public static void printSalary(double[] salaries){
        System.out.println("The hourly salaries are: ");
        for(int i = 0; i < salaries.length; i++){
            System.out.printf("$%4.2f ", salaries[i]);
        }
        //new line
        System.out.println();
    }
    
    //Instance method called averageSalary to return average hourly salary
    public double averageSalary(double[] salaries){
        double sum = 0;
        for(int i = 0; i < salaries.length; i++){
            sum+= salaries[i];
        }
        return sum / salaries.length;
    }
    
    //Instance method called highestSalary to print the highest hourly salary
    public void highestSalary(double[] salaries){
        double highestSalary = salaries[0];
        for(int i = 1; i < salaries.length; i++){
            if(salaries[i] > highestSalary){
                highestSalary = salaries[i];
            }
        }
        System.out.printf("The highest hourly salary is $%4.2f.\n", 
                highestSalary);
    }
    
    //Instance method called lowestSalary to print the lowest hourly salary
    public void lowestSalary(double[] salaries){
        double lowestSalary = salaries[0];
        for(int i = 1; i < salaries.length; i++){
            if(salaries[i] < lowestSalary){
                lowestSalary = salaries[i];
            }
        }
        System.out.printf("The lowest hourly salary is $%4.2f.\n",
                lowestSalary);
    }
    
    //Instance method called belowAverageSalary to return the number
    //of employees with less than the average hourly salary
    public int belowAverageSalary(double[] salaries, double averageSalary){
        int belowAverageCount = 0;
        for(int i = 0; i < salaries.length; i++){
            if(salaries[i] < averageSalary){
                belowAverageCount++;
            }
        }
        return belowAverageCount;
    }
}
