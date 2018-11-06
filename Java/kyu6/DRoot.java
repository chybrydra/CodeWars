/* kyu6
In this kata, you must create a digital root function.

A digital root is the recursive sum of all the digits in a number. Given n, take the sum of the digits of n. If that value has two digits, continue reducing in this way until a single-digit number is produced. This is only applicable to the natural numbers.

Here's how it works:

digital_root(132189)
        => 1 + 3 + 2 + 1 + 8 + 9
        => 24 ...
        => 2 + 4
        => 6
*/


public class DRoot {
    public static int digital_root(int n) {

        String numberString;
        int oldNumber = n;
        int newNumber = 0;

        while (oldNumber>9) {
            numberString = String.valueOf(oldNumber);
            for (int i = 0; i < numberString.length(); i++) {
                newNumber += Character.getNumericValue(numberString.charAt(i));
            }
            oldNumber = newNumber;
            newNumber = 0;
        }

        return oldNumber;
    }
}