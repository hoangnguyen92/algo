package problemsolver;

public class Print2DArray {

    /**
     * input = 3
     * 123
     * 894
     * 765
     * <p>
     * input = 4
     * 01 02 03 04
     * 12 13 14 05
     * 11 16 15 06
     * 10 09 08 07
     * <p>
     * input = 8
     * 1 2 3 4 5 6 7 8
     * 28 29 30 31 32 33 34 9
     * 27 48 49 50 51 52 35 10
     * 26 47 60 61 62 53 36 11
     * 25 46 59 64 63 54 37 12
     * 24 45 58 57 56 55 38 13
     * 23 44 43 42 41 40 39 14
     * 22 21 20 19 18 17 16 15
     */
    public static void main(String[] args) {
        int[][] array = printArray(8);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] printArray(int n) {
        int[][] result = new int[n][n];
        String direction = "R";
        int row = 0, col = 0;

        for (int i = 1; i <= n * n; i++) {
            result[row][col] = i;

            if (direction.equals("R")) {
                if (col + 1 < n && result[row][col + 1] == 0) {
                    col++;
                } else {
                    direction = "D";
                    row++;
                }
            } else if (direction.equals("D")) {
                if (row + 1 < n && result[row + 1][col] == 0) {
                    row++;
                } else {
                    direction = "L";
                    col--;
                }
            } else if (direction.equals("L")) {
                if (col - 1 >= 0 && result[row][col - 1] == 0) {
                    col--;
                } else {
                    direction = "U";
                    row--;
                }
            } else if (direction.equals("U")) {
                if (row - 1 >= 0 && result[row - 1][col] == 0) {
                    row--;
                } else {
                    direction = "R";
                    col++;
                }
            }
        }

        return result;
    }
}
