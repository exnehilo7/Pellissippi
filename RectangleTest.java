/*
 * Date: 05-NOV-2019
 * Programmer: Dan Hopp
 * Description: Test the Rectangle class. Do:
    • Create a Rectangle object called rectangle1 with width 4.0 and height 
      40.0.
    • Display width, height, area, and perimeter of the rectangle1 object.
    • Create a Rectangle object called rectangle2 with width 3.5 and height 
      35.9. 
    • Display width, height, area, and perimeter of the rectangle2 object.

 */
package lab7;


public class RectangleTest {
    
    public static void main(String[] args){
        //Create a Rectangle object called rectangle1 with width 4.0 and height 
        //40.0
        Rectangle rectangle1 = new Rectangle(4.0, 40.0);
        //Display width, height, area, and perimeter of the rectangle1 object
        System.out.println("Rectangle 1 Width = " + rectangle1.width 
                + ", Height = " + rectangle1.height + ", Area = " 
                + rectangle1.getArea() + ", Perimeter = " 
                + rectangle1.getPerimeter());
        
        //Create a Rectangle object called rectangle2 with width 3.5 and height 
        //35.9
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);
        //Display width, height, area, and perimeter of the rectangle2 object
        System.out.println("Rectangle 2 Width = " + rectangle2.width 
                + ", Height = " + rectangle2.height + ", Area = " 
                + rectangle2.getArea() + ", Perimeter = " 
                + rectangle2.getPerimeter());

    }
}
