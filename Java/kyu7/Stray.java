/* 7kyu
examples:
[1, 1, 2] ==> 2
[17, 17, 3, 17, 17, 17, 17] ==> 3
*/

public class Stray {
    static int stray(int[] numbers) {
        int result = 0;
        if (numbers[0]!=numbers[1]) {
            if (numbers[0] == numbers[2]) return numbers[1];
            if (numbers[1] == numbers[2]) return numbers[0];
        }
        else{
            for (int i=2; i<numbers.length; i++){
                if (numbers[i]!=numbers[i-1]) return numbers[i];
            }
        }
     return result;
    }
}
