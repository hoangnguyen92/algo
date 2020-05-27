package leetcodepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Note:
     * <p>
     * The solution set must not contain duplicate triplets.
     * <p>
     * Example:
     * <p>
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * <p>
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */

    /**
     * List<List<Integer>> result;
     * Set<Integer> numbers = new HashSet<>();
     * for from i=0 to array.length     // 0
     * int remain = 0 - array[i];  // 1
     * numbers = new HashSet<>()
     * for from j=1 to array.length
     * //find 2 numbers add up to remain
     * int n = array[j];       //0 1
     * int numberNeeded = remain - n; // 1 0
     * if(numbers.contains(numberNeeded)){
     * result.add(new ArrayList<Integer>({array[i],n, numberNeeded}))
     * }else{
     * numbers.add(array[j]) {0,}
     * }
     */
    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int prevNumber = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && prevNumber == nums[i]) {
                continue;
            }
            prevNumber = nums[i];
            int remain = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (low > i + 1 && nums[low] == nums[low - 1]) {
                    low++;
                    continue;
                }

                if (high < nums.length - 2 && nums[high] == nums[high + 1]) {
                    high--;
                    continue;
                }

                if (remain == nums[low] + nums[high]) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (remain > nums[low] + nums[high]) {
                    low++;
                } else if (remain < nums[low] + nums[high]) {
                    high--;
                }
            }
        }

        return result;
    }
}
