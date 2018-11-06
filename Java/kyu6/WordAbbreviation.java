/*
The word i18n is a common abbreviation of internationalization in the developer community, used instead of typing the whole word and trying to spell it correctly. Similarly, a11y is an abbreviation of accessibility.

Write a function that takes a string and turns any and all "words" (see below) within that string of length 4 or greater into an abbreviation, following these rules:

    A "word" is a sequence of alphabetical characters. By this definition, any other character like a space or hyphen (eg. "elephant-ride") will split up a series of letters into two words (eg. "elephant" and "ride").
    The abbreviated version of the word should have the first letter, then the number of removed characters, then the last letter (eg. "elephant ride" => "e6t r2e").
	
	example:
	abbreviate("elephant-rides are really fun!") => "e6t-r3s are r4y fun!"
*/

public class WordAbbreviation{

	public String abbreviate(String string) {		
		string += " ";
		String result = "";
		String buffer = "";
		
		for (int i=0; i<string.length(); i++){
			if (Character.isLetter(string.charAt(i))) {
				while (Character.isLetter(string.charAt(i))) {
					buffer+=string.charAt(i); 
					i++;
				}
			
			if (buffer.length()>3) { 
				result = result + buffer.charAt(0) + String.valueOf(buffer.length()-2) + buffer.charAt(buffer.length()-1);
			}
			else result +=buffer;
			
			buffer=""; 
			i--;
			}
			else {result+=string.charAt(i);}
		}				
	return result.substring(0, result.length()-1);
	}
}