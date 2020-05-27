package leetcodepractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterNumber {
    /**
     * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
     * <p>
     * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
     * <p>
     * Example 1:
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * Output: [-1,3,-1]
     * Explanation:
     * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
     * For number 1 in the first array, the next greater number for it in the second array is 3.
     * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
     * Example 2:
     * Input: nums1 = [2,4], nums2 = [1,2,3,4].
     * Output: [3,-1]
     * Explanation:
     * For number 2 in the first array, the next greater number for it in the second array is 3.
     * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
     */
    public static void main(String[] args) {
        /**
         * [4,1,2]
         * [1,3,4,2]
         */
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int[] res = new int[nums1.length];
//
//        for (int i = 0; i < nums1.length; i++) {
//            boolean isFound = false;
//            for (int j = i; j < nums2.length; j++) {
//                if (nums1[i] < nums2[j]) {
//                    res[i] = nums2[j];
//                    isFound = true;
//                    break;
//                }
//            }
//
//            if (!isFound) {
//                res[i] = -1;
//            }
//        }
//
//        return res;

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
