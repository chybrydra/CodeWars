/* 7kyu
Simple kata where I need to return the area 
of a circle, being given a radius. 
The result must containt exactly 2 decimal places.
If radius<=0, i am must to throw the IllegalArgumentException
*/

import java.text.DecimalFormat;

public class Circle {
    public static double area(double radius) {
        if (radius<=0) throw new IllegalArgumentException("Argument should be more than 0!");
        DecimalFormat df = new DecimalFormat("#.##");
        double areaOfCircle = Math.PI*radius*radius;
        double result = Double.valueOf(df.format(areaOfCircle));
        return result;

    }
}