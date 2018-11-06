/* 7kyu
TASK:
I have found a class which operates on Arrays of Pairs (Array of length 2) of any type. It should return two Arrays of pairs (as an Array), where the first entry is original input, and the second entry is the array where all pairs are swapped. Somehow it does not work.
Find the bug(s)!
Input is always a non-empty Array of dimension [n][2], (n>0).
Below the method that needs to be fixed:

public class Swappairs {

    public Object[][][] swapp(Object[][] input) {
    Object[][] outp=input;
    for(Object[] oe:outp){
      oe[0]=oe[1];
      oe[1]=oe[0];   
      }    
   
    Object[][][] res={input,outp};
        return res;
    }
}
*/

 public class Swappairs {

	public Object[][][] swapp(Object[][] input) {
		Object[][] outp = new Object[input.length][2];		
		for (int i=0; i<input.length; i++) {
			//Object buffer = outp[i][0];
			outp[i][0]=input[i][1];
			outp[i][1]=input[i][0];
		}

		Object[][][] res = { input, outp };
		return res;
	}
}

