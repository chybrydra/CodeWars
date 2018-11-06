/* 8kyu
You will be given an vector of string(s). You must sort it alphabetically (case-sensitive!!) and then return the first value.
The returned value must be a string, and have "***" between each of its letters.
You should not remove or add elements from/to the array.
so:
twoSort({"bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"}) ==> "b***i***t***c***o***i***n"
twoSort({"turns", "out", "random", "test", "cases", "are", "easier", "than", "writing", "out", "basic", "ones"}) ==> "a***r***e"
*/

import java.util.Arrays;
import java.util.Collections;

public class SortAndStar {

    public static String twoSort(String[] s) {
        String[] sorted = s;
        Collections.sort(Arrays.asList(sorted));
        String result = "" + sorted[0].charAt(0);
        for (int i=1; i<sorted[0].length(); i++){
            result += "***" + sorted[0].charAt(i);
        }
        return result;
    }
}
