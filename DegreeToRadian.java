/*
 * Programmer: Dan Hopp
 * Date: 29-SEP-2019
 * Description: Convert angles 20, 40, 60, and 80 from degrees to radians, and
 *  compute their sines, cosines, and tangents. Degrees and radians should be
 *  in a table 27 * wide. Sin, cos, and tan should be in a table of = 48 wide
 */
package lab4;


public class Problem1 {
    
    public static void main(String[] arg) {

        //declare constants
        //angles
        final int ANGLE_20 = 20;
        final int ANGLE_40 = 40;
        final int ANGLE_60 = 60;
        final int ANGLE_80 = 80;
        //angles' radians
        final double ANGLE_20_RADIANS = Math.toRadians(ANGLE_20);
        final double ANGLE_40_RADIANS = Math.toRadians(ANGLE_40);
        final double ANGLE_60_RADIANS = Math.toRadians(ANGLE_60);
        final double ANGLE_80_RADIANS = Math.toRadians(ANGLE_80);

        //display degrees and radians table, 27 wide
        System.out.println("***************************");
        System.out.printf("%-15s%-7s\n", "Degrees", "Radians");
        System.out.println("***************************");
        System.out.printf("%-15d%-5.3f\n", ANGLE_20, ANGLE_20_RADIANS);
        System.out.printf("%-15d%-5.3f\n", ANGLE_40, ANGLE_40_RADIANS);
        System.out.printf("%-15d%-5.3f\n", ANGLE_60, ANGLE_60_RADIANS);
        System.out.printf("%-15d%-5.3f\n", ANGLE_80, ANGLE_80_RADIANS);
        System.out.println("***************************");

        //display sin, cos, and tan table, 48 wide
        System.out.println("================================================");
        System.out.printf("%-10s%-10d%-10d%-10d%-10d\n", "Angle",
                ANGLE_20, ANGLE_40, ANGLE_60, ANGLE_80);
        System.out.println("================================================");
        System.out.printf("%-10s%-10.3f%-10.3f%-10.3f%-10.3f\n", "Sine",
                Math.sin(ANGLE_20_RADIANS), Math.sin(ANGLE_40_RADIANS),
                Math.sin(ANGLE_60_RADIANS), Math.sin(ANGLE_80_RADIANS));
        System.out.printf("%-10s%-10.3f%-10.3f%-10.3f%-10.3f\n", "Cosine",
                Math.cos(ANGLE_20_RADIANS), Math.cos(ANGLE_40_RADIANS),
                Math.cos(ANGLE_60_RADIANS), Math.cos(ANGLE_80_RADIANS));
        System.out.printf("%-10s%-10.3f%-10.3f%-10.3f%-10.3f\n", "Tangent",
                Math.tan(ANGLE_20_RADIANS), Math.tan(ANGLE_40_RADIANS),
                Math.tan(ANGLE_60_RADIANS), Math.tan(ANGLE_80_RADIANS));
        System.out.println("================================================");

    }
}
