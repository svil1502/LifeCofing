import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {
    public static void main(String[] args) {
        char[][] grid = {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};

        char[][] grid2 = {{'.', '.', '.', '.', '2', '.', '.', '9', '.'},
                {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                {'7', '1', '.', '.', '7', '5', '.', '.', '.'},
                {'.', '7', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '8', '3', '.', '.', '.'},
                {'.', '.', '8', '.', '.', '7', '.', '6', '.'},
                {'.', '3', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '1', '.', '2', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '.', '3', '.', '.', '.', '.'}};


        char[][] grid3 =      {{'.','4','.','.','.','.','.','.','.'},
                               {'.','.','4','.','.','.','.','.','.'},
                               {'.','.','.','1','.','.','7','.','.'},
                               {'.','.','.','.','.','.','.','.','.'},
                               {'.','.','.','3','.','.','.','6','.'},
                               {'.','.','.','.','.','6','.','9','.'},
                               {'.','.','.','.','1','.','.','.','.'},
                               {'.','.','.','.','.','.','2','.','.'},
                               {'.','.','.','8','.','.','.','.','.'}}; //false




        System.out.println(solution(grid3));
    }

    static boolean solution(char[][] grid) {
        HashSet<Character> valid = new HashSet<Character>();

        boolean result = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] != ('.')) {
                    if (valid.contains(grid[i][j])) {
                        result = false;
                    }
                    valid.add(grid[i][j]);
                }

            }
            valid.clear();

        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[j][i] != ('.')) {
                    if (valid.contains(grid[j][i])) {
                        result = false;
                    }
                    valid.add(grid[j][i]);
                }

            }
            valid.clear();

        }


        int p = 0;
        int x = 0;
        for (int t = 0; t < 9; t++) {
            System.out.println("t = " + t);
            for (int k = p; k < 9; k = k + 3) {
                for (int i = x; i < x + 3; i++) {
                    for (int j = x; j < p + 3; j++) {
                        System.out.print(i + ":" + j + ":" + grid[i][j] + " ");
                        //  System.out.println("P = " + p);
                        if (grid[i][j] != ('.')) {
                            if (valid.contains(grid[i][j])) {
                                result = false;
                            }
                            valid.add(grid[i][j]);
                        }


                    }
                    System.out.println();

                }
                System.out.println("---------------");
                valid.clear();
                p = p + 3;
                // x = x + 3;

            }
            System.out.println("---------------");
            System.out.println("---------------");
            t = t +3;
        }

        return result;
    }
        }


