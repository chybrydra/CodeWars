/* 8kyu
being given mpg (miles per gallon) 
convert it kilometers per liter
result should be returned with 2 decimal places
1 Imperial Gallon = 4.54609188 litres 
1 Mile = 1.609344 kilometres
*/

import java.util.Locale;

public class Converter {
    public static float mpgToKPM(final float mpg) {
        float result = 1.609344f/4.54609188f*mpg;
        return Float.parseFloat(String.format(/*Locale.ENGLISH, */"%.2f", result));
    }
}
