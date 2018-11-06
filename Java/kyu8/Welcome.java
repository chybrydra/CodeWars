/* 8kyu
I'm given a list of languages and greetings in those languages.
I have to manage somehow all data (did it in excel with "ifs")
and then return the greeting depending on a language that I get
*/

public class Welcome {
    public static String greet(String language){

        String answer ="Welcome";
        if (language.equals("english")) answer="Welcome";
        if (language.equals("czech")) answer="Vitejte";
        if (language.equals("danish")) answer="Velkomst";
        if (language.equals("dutch")) answer="Welkom";
        if (language.equals("estonian")) answer="Tere tulemast";
        if (language.equals("finnish")) answer="Tervetuloa";
        if (language.equals("flemish")) answer="Welgekomen";
        if (language.equals("french")) answer="Bienvenue";
        if (language.equals("german")) answer="Willkommen";
        if (language.equals("irish")) answer="Failte";
        if (language.equals("italian")) answer="Benvenuto";
        if (language.equals("latvian")) answer="Gaidits";
        if (language.equals("lithuanian")) answer="Laukiamas";
        if (language.equals("polish")) answer="Witamy";
        if (language.equals("spanish")) answer="Bienvenido";
        if (language.equals("swedish")) answer="Valkommen";
        if (language.equals("welsh")) answer="Croeso";

        return answer;
    }
}