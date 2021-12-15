/*
 * Date: 06-NOV-2019
 * Programmer: Dan Hopp
 * Description: A class to represent an airline flight. It will contain:
    • Instance data to represent airline name, flight number, flight origin 
      city, and flight destination city.
    • Static variable to keep track of the total number of flights created.
    • A no-argument constructor to create a default flight.
    • A constructor to create a flight with the airline name, flight number, 
      flight origin city, and flight destination city.
    • Getter and setter methods for all instance data.
    • A toString method to return the description of a flight.
    • A static method to return the total number of flights created.

 */
package lab7;


public class Flight {
    //Instance variables for airline name, flight number, flight origin 
    //city, and flight destination city
    private String airlineName;
    private String flightNumber;
    private String flightOrigin;
    private String flightDestination;
    //Static variable for total number of flights created
    private static int flightCount;
    
    //No-argument constructor to create a default flight
    public Flight(){
        this("N/A", "N/A", "N/A", "N/A");
    }
    //Constructor to create a flight with the airline name, flight number, 
    //flight origin city, and flight destination city
    public Flight(String airlineName, String flightNumber, String flightOrigin, 
        String flightDestination){
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.flightOrigin = flightOrigin;
        this.flightDestination = flightDestination;
        flightCount++;
    }
    
    //Getter methods
    public String getAirlineName(){
        return airlineName;
    }
    public String getFlightNumber(){
        return flightNumber;
    }
    public String getFlightOrigin(){
        return flightOrigin;
    }
    public String getFlightDestination(){
        return flightDestination;
    }
    //Static method to return number of flights created
    public static int getFlightCount(){
        return flightCount;
    }
    
    //Setter methods
    public void setAirlineName(String airlineName){
        this.airlineName = airlineName;
    }
    public void setFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }
    public void setFlightOrigin(String flightOrigin){
        this.flightOrigin = flightOrigin;
    }
    public void setFlightDestination(String flightDestination){
        this.flightDestination = flightDestination;
    }
 
    //toString to return the description of a flight
    public String toString(){
        String output = "Airline Name: " + airlineName;
        output = output + "\nFlight Number: " + flightNumber;
        output = output + "\nFlight Origin City: " + flightOrigin;
        output = output + "\nFlight Destination City: " + flightDestination;
        return output;
    }
}
