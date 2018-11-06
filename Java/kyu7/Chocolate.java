/* 7kyu, given n x m chocolate
return a minimum number of moves to break it to 1x1 pieces
 */

public class Chocolate{

    public static int breakChocolate(int n, int m) {
        if ((n >= 1) && (m >= 1)) {
            return (n - 1) + (m - 1) * n;
        }
        else return 0;
    }
}