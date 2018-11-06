/* 7kyu,
return an array (examples below explain it)
examples:
sumOfN(5) => [0,1,3,6,10,15],
sumOfN(-5) => [0,-1,-3,-6,-10,-15]
sumOfN(7) => [0,1,3,6,10,15,21,28]
0 ; 1(0+1) ; 3(0+1+2) ; 6(0+1+2+3) ; 10(0+1+2+3+4) ; etc.
*/

public class SequenceSum {
    public static int[] sumOfN(int n) {
        int resultLen = Math.abs(n)+1;
        int[] result = new int[resultLen];
        int sum = 0;
        for (int i=0; i<resultLen;i++){
            result[i]=sum;
            if (n<0) sum = sum - i - 1;
            else sum += i+1;
        }
        return result;
    }
}

/*
public static int[] sumOfN(int n) {
    int count = 0;
    ArrayList<Integer> result = new ArrayList<>();
    while(count<Math.abs(n)+1){
        result.add(IntStream.range(0,count+1).sum());
        count ++;
    }
    if(n<0){
        return result.stream().mapToInt(i ->-i).toArray();
    }else
        return result.stream().mapToInt(i ->i).toArray();
}
 */