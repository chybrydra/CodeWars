/* kyu7
standard Collatz recursion:
-if the number is even, modify it this way: x/2+1
-if the number is odd, modify it this way: 3x+1
-do those till you reach 1
-return an amount of steps
*/


public class Collatz {
    public static long conjecture(long x) {
        if (x==1) return 1;
        else if (x%2==0) return conjecture(x/2)+1;
        else return conjecture(3*x+1)+1;
    }
}