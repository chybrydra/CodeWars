/* 8kyu, however made it 6kyu way due to lack of information...
this one checks if a number is a Wilson Prime"
-if it's even
-if ((P-1)! + 1)%(P * P) == 0
even if it is a very very high number (use of BigDecimal)
basically it's a dumb kata where I need to check 3 first wilson primes
but I made it way harder by checking some higher numbers...
*/

import java.math.BigDecimal;

public class WilsonPrimes {

    public static boolean am_i_wilson(double n) {

        if ((n==0)||(n==1)) return false; //those numbers are not even prime

        boolean isPrime = true;
        boolean isWilson = false;

        //verifying if the number is prime;
        for (int i=2; i<n; i++){
            if (n%i==0) return false;
        }

        //verifying if the numbers is "Wilson"
         isWilson = isItWilson(n);

        return isWilson&&isPrime;
    }

    public static boolean isItWilson(double n){
        BigDecimal x = new BigDecimal(1);
        for (int i=2; i<n; i++){
            x = x.multiply(BigDecimal.valueOf(i));
        }
        x = x.add(BigDecimal.valueOf(1));
        BigDecimal y = new BigDecimal(n*n);
        return (x.remainder(y).compareTo(BigDecimal.ZERO) == 0); //checks if x%y == 0
    }

}

/*

* */