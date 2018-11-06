/* 4kyu
Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.
The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.

Examples:
TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
TimeFormatter.formatDuration(15731080) // returns "128 days, 1 hour, 44 minutes and 40 seconds"
TimeFormatter.formatDuration(31536001) // returns "1 year and 1 second"

Restricions:
The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.
A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.
Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
 */

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {
    public static String formatDuration(int timeInSec) {
        if (timeInSec==0) return "now";

        //counting sec/min/hr/days/yrs
        int seconds = timeInSec%60;
        int minutes = timeInSec/60%60;
        int hours = timeInSec/3600%24;
        int days = (timeInSec/86400)%365;
        int years = timeInSec/31536000;

        /*listing as Strings only values that are not 0
        if seconds = 5 ==> I add a String "5 seconds" to the list
        if minutes = 0 ==> I do not add anything to the list
        result list may look for example like this: (5 years, 1 day, 15 seconds)*/
        List<String> resultsList = new ArrayList<String>();
        if (years!=0)       resultsList.add(unitToString("year",years));
        if (days!=0)        resultsList.add(unitToString("day",days));
        if (hours!=0)       resultsList.add(unitToString("hour",hours));
        if (minutes!=0)     resultsList.add(unitToString("minute",minutes));
        if (seconds!=0)     resultsList.add(unitToString("second",seconds));
        //and return a list merged by a method "mergeYrDayHrMinSec"
        return mergeYrDayHrMinSec(resultsList);
    }

    public static String unitToString(String unitName, int amount){
        /* =====================================
        unitToString("hour",5) => return "5 hours"
        unitToString("minute",1) => return "1 minute" (no "s" at the end)
        ========================================*/
        if (amount==1) return "" + amount + " " + unitName;
        else return "" + amount + " " + unitName + "s";
    }

    public static String mergeYrDayHrMinSec(List<String> listToMerge){
        String result = "";
        result += listToMerge.get(0);
        for (int i = 1; i < listToMerge.size()-1; i++) {
            result += ", " + listToMerge.get(i);
        }
        if (listToMerge.size()>1) result += " and " + listToMerge.get(listToMerge.size()-1);
        return result;
    }
}