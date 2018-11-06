/* 6kyu
Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to it's position in the alphabet: a = 1, b = 2, c = 3 etc.
You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.
All letters will be lowercase and all inputs will be valid.
*/

public class HighestScoringWord{

  public static String high(String str) {
    String[] parts = str.split(" ");
    int maxPointsSoFar = wordPoints(parts[0]); int maxIndex=0;
    for (int i=1; i<parts.length; i++) {
      if (wordPoints(parts[i])>maxPointsSoFar) {maxPointsSoFar=wordPoints(parts[i]); maxIndex=i;}
    }
  return parts[maxIndex];
  }    
  
  
  public static int wordPoints(String word) {
    int lettersSummed = 0;    
    for (int i=0; i<word.length(); i++) {
      lettersSummed+= (int) (word.charAt(i)-96);
    }    
    return lettersSummed;
  }
}