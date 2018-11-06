/* no idea of kyu, probably 7
being given an array of integer, 
"delete" integers that appear more than once 
and return an array of those numbers
no sorting!
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays.*;

public class UniqueArray {
    public static int[] unique(int[] integers) {

        //int[] to List of Integers
        List<Integer> listOfInt = IntStream.of(integers).boxed().collect(Collectors.toList());

        int toCheck;
        for (int i=0; i<listOfInt.size(); i++){
            toCheck = listOfInt.get(i);
            for (int j=i+1; j<listOfInt.size(); j++){
                if (toCheck==listOfInt.get(j)) {listOfInt.remove(j);j--;}
            }
            System.out.println();
        }

        return listOfInt.stream().mapToInt(i->i).toArray();
    }
}

