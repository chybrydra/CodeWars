/* kyu5
Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying: F(n) * F(n+1) = prod.

productFib(800) = {34, 55, 0}
because: F(8)=21, F(9)=34, F(10)=55 and 21*34<800<34*55
0 means that there doesn't exist such pair of Fibonacci numbers that F(n) * F(n+1) = prod.

productFib(714) = {21, 34, 1}, 
because: F(8)=21, F(9)=34 and 714=21*34

*/

public class ProdFib {

    public static long[] productFib(long prod) {
        long n0=0;
        long n1=1;
        long buffer = 0;

        while (n0*n1<prod) {
            buffer = n1 + n0;
            n0 = n1;
            n1 = buffer;
        }

        if (n0*n1 == prod) return new long[] {n0, n1, 1};
        else return new long[] {n0, n1, 0};
    }
}