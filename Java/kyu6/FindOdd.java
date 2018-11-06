/* 6kyu
Given an array, find the int that appears an odd number of times.
There will always be only one integer that appears an odd number of times.
*/

public class FindOdd {
  	public static int findIt(int[] array) {
    	  int arrLen = array.length;
        int occurencies = 0;
        for (int i=0; i<arrLen; i++){
            for(int j=0; j<arrLen; j++){
                if (array[i]==array[j]) occurencies++;
            }
        if (occurencies%2==1) return array[i];
        occurencies = 0;
        }
    return 0;
    }
}

/* there is also one clever solution (not mine) that I need to add:

public class FindOdd {
  public static int findIt(int[] A) {
    int xor = 0;
    for (int i = 0; i < A.length; i++) {
      xor ^= A[i];
    }
    return xor;
  }
}

/*