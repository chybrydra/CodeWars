/* 5kyu
Once upon a time, on a way through the old wild west,…

… a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too. Going to one direction and coming back the opposite direction is a needless effort. Since this is the wild west, with dreadfull weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!

The directions given to the man are, for example, the following:
["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].

You can immediatly see that going "NORTH" and then "SOUTH" is not reasonable, better stay to the same place! So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
["WEST"]

Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirReduction {
    public static String[] dirReduc(String[] dirArr) {

        List<String> dirList = new ArrayList<String>(Arrays.asList(dirArr));

        for (int i=1 ;i<dirList.size(); i++){
            if (reduces(dirList.get(i), dirList.get(i-1))) {dirList.remove(i-1); dirList.remove(i-1); i=0;}
        }

        String[] result = dirList.toArray(new String[dirList.size()]);

        return result;
    }

    public static boolean reduces(String a, String b){
        if ("SOUTH".equals(a)&&"NORTH".equals(b)) return true;
        if ("SOUTH".equals(b)&&"NORTH".equals(a)) return true;
        if ("WEST".equals(a)&&"EAST".equals(b)) return true;
        if ("WEST".equals(b)&&"EAST".equals(a)) return true;
        return false;
    }
}