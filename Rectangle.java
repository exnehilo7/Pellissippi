/*
 * Date: 05-NOV-2019
 * Programmer: Dan Hopp
 * Description: A class to represent a rectangle. It will contain:
    • Two double data fields named width and height to represent the width and
      height of the rectangle. The default value is 1.0 for both width and 
      height.
    • A no-argument constructor that creates a default rectangle.
    • A constructor that creates a rectangle with the specified width and 
      height.
    • A method named getArea() that returns the area of the rectangle.
    • A method named getPerimeter() that returns the perimeter.

 */
package lab7;


public class Rectangle {
    
    //Data fields
    public double width;
    public double height;
    
    //A no-argument constructor. Set default to 1.0
    public Rectangle(){
        width = 1.0;
        height = 1.0;
    }
    //Constructor with a specified width and height
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    //getArea() method to return the area
    public double getArea(){
        return width * height;
    }
    //getPerimeter() method to return the perimeter
    public double getPerimeter(){
        return 2 * (width + height);
    }
}
