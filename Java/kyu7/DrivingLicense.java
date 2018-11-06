/* 7kyu
"Driving License"

TASK: The UK driving number is made up from the personal details of the driver.
The individual letters and digits can be code using the below information .

RULES:
1–5: The first five characters of the surname (padded with 9s if less than 5 characters)
6: The decade digit from the year of birth (e.g. for 1987 it would be 8)
7–8: The month of birth (7th character incremented by 5 if driver is female i.e. 51–62 instead of 01–12)
9–10: The date within the month of birth
11: The year digit from the year of birth (e.g. for 1987 it would be 7)
12–13: The first two initials of the first name and middle name, padded with a 9 if no middle name
14: Arbitrary digit – usually 9, but decremented to differentiate drivers with the first 13 characters in common. We will always use 9
15–16: Two computer check digits. We will always use "AA"

You will need to output the full 16 digit driving license number.

array "data":
0 - forename;
1 - middle name (if any);
2 - surname;
3 - date of birth (DD-MM-YYYY);
4 - sex (M/F)

Sample tests:
*/

public class DrivingLicense {
    public static String driver(final String[] data) {

        //first of all - splitting the date to {day, month, year}
            String[] dayMonthYear = data[3].split("-"); //String array {day,month,year}
            String month = dayMonthYear[1].substring(0,3); //first 3 letters of month

        //PART 1-5 - five letter of first name uppercase
            String elements1to5 = (data[2]+"99999").substring(0,5).toUpperCase();

        //PART 6-6 --> year/10%10
            String elements6to6 = String.valueOf(dayMonthYear[2].charAt(2));

        //PART 7-8 --> Month (+50 if female)
            String elements7to8 = giveMonth(month, data[4]);

        //PART 9-10 --> day of birth
            String elements9to10 = dayMonthYear[0];

        //PART 11-11 --> year%10
            String elements11to11 = "" + dayMonthYear[2].charAt(3);

        //PART 12-13 --> first letter of first name + first letter of second name or "9"
            String elements12to13 =""+ data[0].charAt(0) + (data[1]+"9").substring(0,1);

        //PART 14-16 --> just 9AA
            String elements14to14 = "9AA";

        return elements1to5 + elements6to6 + elements7to8 + elements9to10 + elements11to11 + elements12to13 + elements14to14;
    }

    public static String giveMonth(String monthName, String sex){
        int result;
        switch (monthName){
            case "Jan": result = 1; break;
            case "Feb": result = 2; break;
            case "Mar": result = 3; break;
            case "Apr": result = 4; break;
            case "May": result = 5; break;
            case "Jun": result = 6; break;
            case "Jul": result = 7; break;
            case "Aug": result = 8; break;
            case "Sep": result = 9; break;
            case "Oct": result = 10; break;
            case "Nov": result = 11; break;
            case "Dec": result = 12; break;
            default: result = 0; break;
        }
        if ("F".equals(sex)) result += 50;
        if (result/10==0) return "0" + String.valueOf(result);
        else return String.valueOf(result);
    }
}

/* TEST CASES FROM CODEWARS:

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest
{
    private static final String[] names = new String[]
    {
        "Eugene", "Kade", "Johanna", "Andrew", "Maddison", "Marin", "Wayne", "Nick", "Mccullough",
        "Sandoval", "Hurst", "Gibbs", "Benson", "Holland", "Crane", "Lee", "Wilson", "Clara", "Zhang",
        "Cummings", "Richmond", "Kadyn", "Stevens", "Laila", "Alan", "Angel", "Yadiel", "Saul", "Jovan",
        "Faith", "King", "Milagros", "Scott", "Brennan", "Ashanti", "Dayton", "Lindsey", "Gilbert",
        "Jamya", "Sam", "Madeleine", "Levine", "Luna", "Addison", "Bethany", "Zoie", "Landyn", "Mireya",
        "Mcgee", "Kirk", "Kirsten", "Kamren", "Vega", "Stephany", "Brooks", "Issac", "Hays", "Jasmin",
        "Benitez", "Alfonso", "Shepherd", "Jenkins"
    };
    private static final String[] months = new String[]
    {
        "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };
    private static int randomInt(int min, int max)
    {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    private static boolean randomBool()
    {
        return randomInt(0, 9999) % 2 == 0 ? true : false;
    }
    private static int randomDay()
    {
        return randomInt(1, 28);
    }
    private static String randomMonth()
    {
        return randomBool() ? months[randomInt(0, 11)] : months[randomInt(0, 11)].substring(0, 3);
    }
    private static int randomYear()
    {
        return randomInt(1930, 2000);
    }
    private static String randomName()
    {
        return names[randomInt(0, names.length-1)];
    }
    private static String randomSex()
    {
        return randomBool() ? "M" : "F";
    }
    @Test
    public void randomTests()
    {
        for (int trial = 1; trial <= 100; trial++)
        {
            String[] data = new String[]{ randomName(),
                                          randomBool() ? randomName() : "",
                                          randomName(),
                                          String.format("%02d-%s-%04d", randomDay(), randomMonth(), randomYear()),
                                          randomSex() };
            System.out.format("Trial #%d\ndata = {", trial);
            for (int i = 0; i < data.length; i++)
                System.out.format("\"%s\"%s", data[i], (i < data.length-1 ? ", " : ""));
            System.out.format("}\n");
            assertEquals(solution(data), Solution.driver(data));
        }
    }
    private static int findMonth(final String m)
    {
        for (int i = 0; i < months.length; i++)
            if ( m.equals(months[i].substring(0, 3)) )
                return i + 1;
        return 0;
    }
    private static String solution(final String[] data)
    {
        String[] date = data[3].split("-");
        return String.format("%s%s%02d%s%s%s9AA",
                             (data[2] + "99999").substring(0, 5),
                             date[2].substring(2, 3),
                             findMonth(date[1].substring(0, 3)) + ("F" == data[4] ? 50 : 0),
                             date[0],
                             date[2].substring(3, 4),
                             (data[0].substring(0, 1) + (data[1].length() > 0 ? data[1].substring(0, 1) : "9")).substring(0, 2))
                     .toUpperCase();
    }
}
 */