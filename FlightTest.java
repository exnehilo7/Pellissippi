/*
 * Date: 06-NOV-2019
 * Programmer: Dan Hopp
 * Description: Test the Flight class. Do:
    • Create a default Flight object called flight1.
    • Print description of the flight1 object.
    • Create a Flight object called flight2 with the following data:
Airline Name	Flight Number	Flight Origin City	Flight Destination City
--------------------------------------------------------------------------------
UML             U234            Chicago                 London

    • Print description of the flight2 object.

    • Create a Flight object called flight3 with the following data:
Airline Name	Flight Number	Flight Origin City	Flight Destination City
--------------------------------------------------------------------------------
Java            J817            Atlanta                 Paris

    • Print description of the flight3 object.
    • Print the number of flight objects created.

 */
package lab7;


public class FlightTest {
    public static void main(String[] args) {
        
        //Create a default Flight object called flight1
        Flight flight1 = new Flight();
        //Print the description of the flight1 object
        System.out.println(flight1 + "\n");
        
        //Create a Flight object called flight2 with "UML", "U234", "Chicago", 
        //"London"
        Flight flight2 = new Flight("UML", "U234", "Chicago", "London");
        //Print the description of the flight2 object
        System.out.println(flight2 + "\n");
        
        //Create a Flight object called flight3 with "Java", "J817", "Atlanta", 
        //"Paris"
        Flight flight3 = new Flight("Java", "J817", "Atlanta", "Paris");
        //Print the description of the flight3 object
        System.out.println(flight3 + "\n");
        
        //Print the number of flight objects created
        System.out.println("Total number of flight objects created: " 
                + Flight.getFlightCount());
    }
}
