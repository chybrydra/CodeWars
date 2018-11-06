/* kyu5
Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
Examples:
pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !*/

public class PigLatin {

    public static String pigIt(String str) {
        String[] wordsToModify = str.split(" ");
        for (int i=0; i<wordsToModify.length; i++){
            if (wordsToModify[i].matches("[a-zA-Z]+")) {
                wordsToModify[i] = modifyPig(wordsToModify[i]);
            }
        }
        return String.join(" ", wordsToModify);
    }

    public static String modifyPig(String str){
        int len = str.length();
        StringBuilder toModify = new StringBuilder(str);
        toModify.append(toModify.subSequence(0,1));
        return (toModify.toString()+"ay").substring(1);
    }
}

/* magic regex solution from CodeWars:
public class PigLatin {
    public static String pigIt(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}
 */