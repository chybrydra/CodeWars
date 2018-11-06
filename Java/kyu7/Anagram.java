/* 7kyu
Here I am am given two strings 
and I need to check if they are anagrams (case sensitive)
So f.e. isAnagram("Hello", "LeLhO") should return boolean true.
*/

import java.util.Arrays;
import java.util.Collections;

public class Anagram {

    public static boolean isAnagram(String test, String original) {
        char[] tempArray1 = test.toLowerCase().toCharArray();
        char[] tempArray2 = original.toLowerCase().toCharArray();
        Arrays.sort(tempArray1);
        Arrays.sort(tempArray2);
        String testSorted = String.valueOf(tempArray1);
        String originalSorted = String.valueOf(tempArray2);
        return testSorted.equals(originalSorted);
    }
}