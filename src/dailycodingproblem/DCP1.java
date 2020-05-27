package dailycodingproblem;

import java.util.HashSet;
import java.util.Set;

public class DCP1 {
    /**
     * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
     * <p>
     * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
     * <p>
     * Bonus: Can you do this in one pass?
     */
    public static void main(String[] args) {
        int[] array = {10, 15, 3, 7};
        int k = 11;

        System.out.println(isPairAddUpTo(array, k));
    }

    private static boolean isPairAddUpTo(int[] array, int k) {
        Set<Integer> numbersNeeded = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if (numbersNeeded.contains(array[i])) {
                return true;
            }

            int numberNeeded = k - array[i];
            numbersNeeded.add(numberNeeded);
        }

        return false;
    }

}
