/* kyu7
Create a method that accepts an array of names, and returns an array of each name with its first letter capitalized.
Example:
Kata.capMe(new String[] {"jo", "nelson", "jurie"}) // returns new String[] {"Jo", "Nelson", "Jurie"}
Kata.capMe(new String[] {"KARLY", "DANIEL", "KELSEY"}) // returns new String[] {"Karly", "Daniel", "Kelsey"}
 */


public class CapMe {
    public static String[] capMe(String[] strings) {
        String[] result = new String[strings.length];

        for (int i=0; i< result.length; i++){
            String replacement = Character.toString(strings[i].toUpperCase().charAt(0));
            String replacement2 = strings[i].substring(1).toLowerCase();
            result[i] = replacement + replacement2;
        }
        return result;
    }
}