/* 7 kyu probably, can't find where it was
SeriesSum(5) => 1 + 1/4 + 1/7 + 1/10 + 1/13 = "1.57"
SeriesSum(3) => 1+1/4+1/7
result with 2 decimal places!
*/

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NthSeries {
    public static String seriesSum(int n) {
        double result = 0;
        for (int i=0; i<n; i++){
            result = result +  (double) 1/(1+3*i);
        }
        return BigDecimal.valueOf(result).setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
    }

    public static String seriesSum2(int n) {
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum += 1.0 / (1 + 3 * i);
        return String.format("%.2f", sum);
    }

    public static String seriesSum3(int n) {
        DecimalFormat df = new DecimalFormat("0.00");
        // Happy Coding ^_^
        double result = 0;
        for(int i = 1;i<=n;i++){
            result = result + 1.0/(3*i-2);
        }
        return df.format(result);
    }

    public static double twoDecimalPlaces(double number)
    {
        String result = BigDecimal.valueOf(number).setScale(2, BigDecimal.ROUND_HALF_EVEN).toString();
        return Double.valueOf(result);
    }

}