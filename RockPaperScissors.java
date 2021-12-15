/*
 * Programmer: Dan Hopp
 * Date: 21-SEP-2019
 * Description: Play a rock-paper-scissor game with the user, using the computer
 * as the opponent.
 *
 * Generate a random number for the PC opponent using the following table:
 * 0 - scissor
 * 1 - rock
 * 2 - paper
 * 
 * Prompt the user for their input, and then determine who is the winner, or if
 * it is a draw.
 *
 * Try using a switch statement. (Within switch I can use if-else)
 */

package lab3;
import java.util.Scanner;

public class Problem2Redux {

    public static void main(String[] arg) {

        //Generate a random number for the computer
        int rng = (int) (Math.random() * 3);

        //Assign a value to a variable for the result
        String pcGuess = "";
        switch (rng) {
            case 0:
                pcGuess = "scissors";
                break;
            case 1:
                pcGuess = "a rock";
                break;
            case 2:
                pcGuess = "paper";
        }

        //Prompt the user for their guess
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your guess "
                + "(scissors 0, rock 1, paper 2): ");
        int userInput = input.nextInt();

        //Determine if the user won, lost, or drew
        //0 scissors, 1 rock, 2 paper
        String result = "";
        String userGuess = "";
        
        switch (userInput) {
            case 0:
                userGuess = "scissors";
                break;
            case 1:
                userGuess = "a rock";
                break;
            case 2:
                userGuess = "paper";
        }
        
        if (userInput == 0 && rng == 0) {
            result = "It is a draw.";
        } else if (userInput == 0 && rng == 1) {
            result = "You lost.";
        } else if (userInput == 0 && rng == 2) {
            result = "You won.";
        } else if (userInput == 1 && rng == 0) {
            result = "You won.";
        } else if (userInput == 1 && rng == 1) {
            result = "It is a draw.";
        } else if (userInput == 1 && rng == 2) {
            result = "You lost.";
        } else if (userInput == 2 && rng == 0) {
            result = "You lost.";
        } else if (userInput == 2 && rng == 1) {
            result = "You won.";
        } else if (userInput == 2 && rng == 2) {
            result = "It is a draw.";
        } else {
            System.out.println("Invalid number.");
            System.exit(0);
        }

        //Display the results
        System.out.println("The computer is " + pcGuess + ". You are "
                + userGuess + ". " + result);

    }
}
