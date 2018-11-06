/*
The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8. It's easy to see that the sum of the perimeters of these squares is : 4 * (1 + 1 + 2 + 3 + 5 + 8) = 4 * 20 = 80

Could you give the sum of the perimeters of all the squares in a rectangle when there are n + 1 squares disposed in the same manner as in the drawing: 
*/

import java.math.BigInteger;

public class SquarePerimeters {

    public static BigInteger perimeter(BigInteger n) {
        BigInteger fiboSum = fibonacciSum(n);
        return fiboSum.multiply(new BigInteger("4"));
    }

    public static BigInteger fibonacciSum(BigInteger n){
        BigInteger previousVal = BigInteger.ZERO;
        BigInteger currentVal = BigInteger.ONE;
        BigInteger buffer = BigInteger.ONE;
        BigInteger summedSoFar = BigInteger.ZERO;
        for (int i=0; i<=n.intValue(); i++){
            previousVal=currentVal;
            currentVal=buffer;
            buffer = previousVal.add(currentVal);
            summedSoFar = summedSoFar.add(previousVal);
        }
        return summedSoFar;
    }
}
