/* 4kyu...
Write a function validSolution/ValidateSolution/valid_solution() that accepts a 2D array representing a Sudoku board, and returns true if it is a valid solution, or false otherwise. The cells of the sudoku board may also contain 0's, which will represent empty cells. Boards containing one or more zeroes are considered to be invalid solutions.
The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.

Examples

validSolution([
  [5, 3, 4, 6, 7, 8, 9, 1, 2],
  [6, 7, 2, 1, 9, 5, 3, 4, 8],
  [1, 9, 8, 3, 4, 2, 5, 6, 7],
  [8, 5, 9, 7, 6, 1, 4, 2, 3],
  [4, 2, 6, 8, 5, 3, 7, 9, 1],
  [7, 1, 3, 9, 2, 4, 8, 5, 6],
  [9, 6, 1, 5, 3, 7, 2, 8, 4],
  [2, 8, 7, 4, 1, 9, 6, 3, 5],
  [3, 4, 5, 2, 8, 6, 1, 7, 9]
]); // => true

validSolution([
  [5, 3, 4, 6, 7, 8, 9, 1, 2],
  [6, 7, 2, 1, 9, 0, 3, 4, 8],
  [1, 0, 0, 3, 4, 2, 5, 6, 0],
  [8, 5, 9, 7, 6, 1, 0, 2, 0],
  [4, 2, 6, 8, 5, 3, 7, 9, 1],
  [7, 1, 3, 9, 2, 4, 8, 5, 6],
  [9, 0, 1, 5, 3, 7, 2, 1, 4],
  [2, 8, 7, 4, 1, 9, 6, 3, 5],
  [3, 0, 0, 4, 8, 1, 1, 7, 9]
]); // => false

 */

import java.util.Arrays;

public class SudokuValidator {
    public static boolean check(int[][] sudoku) {
        if (!verifyRaws(sudoku)) return false;
        if (!verifyColumns(sudoku)) return false;
        if (!verifySmallSquares(sudoku)) return false;
        return true;
    }

    public static boolean verifySmallSquares(int[][] sudoku){
        int[] arrayToCheck = new int[9];
        int index = 0;
        for (int i=0; i<7; i+=3){
            for (int j=0; j<7; j+=3){
                for (int k=0; k<3; k++) {
                    for (int m = 0; m < 3; m++) {
                        arrayToCheck[index] = sudoku[i+k][j+m];
                        if (index < 8) index++;
                    }
                }
                index=0;
                if (!verifyArray(arrayToCheck)) return false;
            }
        }
        return true;
    }

    public static boolean verifyColumns(int[][] sudoku){
        int[] arrayToCheck = new int[9];
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++) {
                arrayToCheck [j] = sudoku[j][i];
            }
            if (!verifyArray(arrayToCheck)) {
                for (int k=0; k<9; k++) {
                }
                return false;
            }
        }
        return true;
    }

    public static boolean verifyRaws(int[][] sudoku){
        int[] arrayToCheck = new int[9];
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++) {arrayToCheck[j]=sudoku[i][j];}
            if (!verifyArray(arrayToCheck)) return false;
        }
        return true;
    }

    public static boolean verifyArray(int[] arrayToVerify){
        //sorting an array
        Arrays.sort(arrayToVerify);
        //checking if the first number is one
        if (arrayToVerify[0]!=1) return false;
        //checking if the rest are ascending
        for (int i=1; i<9; i++){
            if ((arrayToVerify[i]-arrayToVerify[i-1])!=1) return false;
        }
        return true;
    }
}