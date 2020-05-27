package problemsolver;

public class TwoDArraysDs {

    /**
     * find highest hourglass
     * example of hourglass:
     * 1 1 1
     * 1
     * 1 1 1
     * <p>
     * Input:
     * 1 1 1 0 0 0
     * 0 1 0 0 0 0
     * 1 1 1 0 0 0
     * 0 0 2 4 4 0
     * 0 0 0 2 0 0
     * 0 0 1 2 4 0
     * Constrains:
     * -9 <= arr[i][j] <= 9
     * 0 <= i,j <= 5
     * Output:
     * 19
     */
    public void solve() {
        int[][] input = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};
        //expect 4,3,2,1
        int output = hourglassSum(input);

        System.out.println(output);
    }

    private int hourglassSum(int[][] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = 0; j < a[0].length - 2; j++) {
                int temp = calculateHourglassSum(a, i, j);
                if (maxSum < temp) {
                    maxSum = temp;
                }
            }
        }
        return maxSum;
    }

    private int calculateHourglassSum(int[][] a, int x, int y) {
        int sum = a[x][y] + a[x][y + 1] + a[x][y + 2] +
                a[x + 1][y + 1] +
                a[x + 2][y] + a[x + 2][y + 1] + a[x + 2][y + 2];
        System.out.println("Calculate: x=" + x + ", y=" + y + " => sum =" + sum);
        return sum;
    }
}
