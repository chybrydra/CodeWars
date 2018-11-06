/* kyu7
In Japan, a game called Shiritori is played. The rules are simple, a group of people take turns calling out a word whose beginning syllable is the same as the previous player's ending syllable. For example, the first person would say the word ねこ, and the second player must make a word that starts with こ, like　こむぎ. This repeats until a player can not think of a word fast enough or makes a word that ends in ん, because there are no words that begin with ん　in the Japanese language.

English Shiritori has the same principle, with the first and last letters of words. That being said the lose condition is saying a word that doesn't start with the previous word's last letter or not saying a word quick enough.

For example: apple -> eggs -> salmon -> nut -> turkey ...

Your Task:
You will be given a list of strings, a transcript of an English Shiritori match. Your task is to find out if the game ended early, and return a list that contains every valid string until the mistake. If a list is empty return an empty list. If one of the elements is an empty string, that is invalid and should be handled.

Examples:
All elements valid:
The array {"dog","goose","elephant","tiger","rhino","orc","cat"}
should return {"dog","goose","elephant","tiger","rhino","orc","cat"}

An invalid element at index 2:
The array {"dog","goose","tiger","cat", "elephant","rhino","orc"}
should return ("dog","goose") since goose ends in 'e' and tiger starts with 't'

An invalid empty string at index 2:
The array {"ab","bc","","cd"}
should return ("ab","bc")

All invalid empty string at index 0:
The array {"","bc","","cd"}
should return An Empty List
*/

import java.util.*;
public class Shiritori{

    public static List<String> theGame(List<String> words){
          
          List<String> newList = new ArrayList<String>();
          
          if (words.size()==0) return newList;
          if (words.get(0).length()==0) return newList;          
                    
          newList.add(words.get(0));
          
          String previousWord = "";
          String currentWord = "";
          char lastLetter;
          char firstLetter; 
          
          for (int i=1; i<words.size(); i++){
              previousWord = words.get(i-1);
              if (words.get(i).length()==0) break;
              currentWord = words.get(i);
              lastLetter =  previousWord.charAt(previousWord.length()-1);
              firstLetter = currentWord.charAt(0);
              if (lastLetter != firstLetter) break;
              newList.add(currentWord);
          }
          
          return newList;
      }

}