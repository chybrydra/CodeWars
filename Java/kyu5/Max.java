/*
The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
should be 6: {4, -1, 2, 1}
Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */


import java.util.Arrays;

public class Max {
    public static int sequence(int[] arr) {

        if (arr.length==0) return 0;
        if (Arrays.stream(arr).max().getAsInt() < 0) return 0;
        if (Arrays.stream(arr).min().getAsInt() > 0) return Arrays.stream(arr).sum();

        int max = 0;
        int sum = 0;
        int a = 0;

        while (a<arr.length) {
            for (int j = a+1; j <= arr.length; j++) {
                for (int k = a; k < j; k++) {
                    sum += arr[k];
                    System.out.print(","+arr[k]);
                }
                System.out.println("="+sum);
                if (sum > max) max = sum;
                sum = 0;
            }
            a++;
        }

        return max;
    }
}