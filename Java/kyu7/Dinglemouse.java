/* 7kyu
this one is given a number between 1 and 10 
and is supposed to to return the song text
*/

public class Dinglemouse {

    public static String tenGreenBottles(int n) {
        String songText = "";

        String amount = numberAsWord(n);
        String amountAfter = numberAsWord(n-1).toLowerCase();
        while (n>2) {
            songText += amount + " green bottles hanging on the wall,\n";
            songText += amount + " green bottles hanging on the wall,\n";
            songText += "And if one green bottle should accidentally fall,\n";
            songText += "There'll be " + amountAfter + " green bottles hanging on the wall.\n\n";
            n--;
            amount = numberAsWord(n);
            amountAfter = numberAsWord(n-1).toLowerCase();
        }

        if (n==2){
            songText += amount + " green bottles hanging on the wall,\n";
            songText += amount + " green bottles hanging on the wall,\n";
            songText += "And if one green bottle should accidentally fall,\n";
            songText += "There'll be " + amountAfter + " green bottle hanging on the wall.\n\n";
        }

        songText += "One green bottle hanging on the wall,\n";
        songText += "One green bottle hanging on the wall,\n";
        songText += "If that one green bottle should accidentally fall,\n";
        songText += "There'll be no green bottles hanging on the wall.\n";


        return songText;
    }

    public static String numberAsWord(int x){
        String result = "";
        switch(x){
            case 1: result += "One"; break;
            case 2: result += "Two"; break;
            case 3: result += "Three"; break;
            case 4: result += "Four"; break;
            case 5: result += "Five"; break;
            case 6: result += "Six"; break;
            case 7: result += "Seven"; break;
            case 8: result += "Eight"; break;
            case 9: result += "Nine"; break;
            case 10: result += "Ten"; break;
            default: result +=""; break;
        }
        return result;
    }


}
