package dailycodingproblem;

public class DCP4 {
    /**
     * Given an array of integers, find the first missing positive integer in linear time and constant space.
     * In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
     * <p>
     * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
     * <p>
     * You can modify the input array in-place.
     */
    public static void main(String[] args) {
        int[] input = {1, 2, 0};

        System.out.println(findMissingPositiveNumber(input));
    }

    private static int findMissingPositiveNumber(int[] input) {
        int indexToSwap = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                int temp = input[i];
                input[i] = input[indexToSwap];
                input[indexToSwap] = temp;
                indexToSwap++;
            }
        }

        for (int i = indexToSwap; i < input.length; i++) {
            int index = Math.min(input.length - 1, Math.abs(input[i] - 1));
            if (input[index] > 0) {
                input[index] = Math.abs(input[index]) * -1;
            }
        }

        for (int i = indexToSwap; i < input.length; i++) {
            if (input[i] > 0) {
                return i + 1;
            }
        }
        return input.length;
    }

}
