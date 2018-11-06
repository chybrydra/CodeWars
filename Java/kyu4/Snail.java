/*========================================
This is my first 4kyu Kata from CodeWars

TASK:
Given an n x n array,
return the array elements arranged
from outermost elements to the middle element,
travelling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
 =====================================*/

public class Snail {

    public static int[] snail(int[][] array) {

        if (array.length != 0 && array[0].length == 0) {int[] result  = new int[0]; return result;}

        int dir=1;                                 // setting direction to 1, 1==east, 2==south, 3==west, 4==north
        int sqrSize=array.length;                  //square size;
        int stepsToDo = sqrSize-1;                 //steps to do in one direction before changing direction
        int[] result = new int[sqrSize*sqrSize];   //here I will put the numbers "collected"
        int currentX=0; int currentY=0;
        int resultIndex=0;

        //first to-the-east steps are out of pattern so I'll do them before looping
        result[resultIndex] = array[currentX][currentY];
        for (int i=0; i<stepsToDo; i++) {
            currentY++; resultIndex++;
            result[resultIndex]=array[currentX][currentY];
        }
        dir = changeDirection(dir);

      /*-------------------------------------------------
      here I reached the end of the first raw
      from now on I only need to change direction at the right moment
      there is a pattern to walk:
      (n-1)-steps-south, (n-1)-steps-west,
      (n-2)-steps-north, (n-2)-steps-east,
      (n-3) steps south, (n-3) steps west, etc.
      -------------------------------------------------*/
        while(stepsToDo>0) {
            for (int i=0; i<2; i++) {
                for (int j=0; j<stepsToDo; j++) {
                    if (dir==1) {currentY++;}
                    else if(dir==2) {currentX++;}
                    else if(dir==3) {currentY--;}
                    else {currentX--;}
                    resultIndex++;
                    result[resultIndex]=array[currentX][currentY];
                }
                dir = changeDirection(dir); //just changing the direction that I'm going
            }
            stepsToDo--;
        }

        return result;
    }

    /*-------------------------------------------------
    just to change the direction that I'm walking:
    1 - to east, 2 - to south, 3 - to west, 4 - to north
    -------------------------------------------------*/
    public static int changeDirection(int dir) {
        if (dir<4) {dir++;}
        else dir=1;
        return dir;
    }
}