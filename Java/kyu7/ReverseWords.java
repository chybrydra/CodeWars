/* 7kyu
examples:
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"
*/
public class ReverseWords {
    public static String reverseWords(final String original) {

        if (original.replace(" ", "").length()==0) return original;

        String[] array = original.split(" ");
        String result = new String();

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length(); j++) {
                result += array[i].charAt(array[i].length() - j - 1);
            }
            result += " ";
        }
        return result.substring(0,result.length()-1);
    }
}
