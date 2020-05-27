package problemsolver;

import java.util.Arrays;

public class ArraysDs {

    /**
     * Input:
     * - first line N = number of integers in Array
     * - second line contains N spaced-separated integers describing array A
     * Constrains:
     * 1 <= N <= 10^3
     * 1 <= Ai <=10^4
     * <p>
     * Output:
     * Print all N integers in A in reverse order as a single line of space-separated integers.
     */
    public void solve() {
        int[] input = {1, 2, 3, 4};
        //expect 4,3,2,1
        int[] output = reverseArray(input);

        System.out.println(Arrays.toString(output));
    }

    private int[] reverseArray(int[] a) {
        int lastIndex = a.length - 1;
        for (int i = 0; i < a.length / 2; i++) {
            swapInteger(a, i, lastIndex - i);
        }
        return a;
    }

    private void swapInteger(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
