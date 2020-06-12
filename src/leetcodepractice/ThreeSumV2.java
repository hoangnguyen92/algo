package leetcodepractice;

import java.util.*;

public class ThreeSumV2 {
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

        System.out.println(threeNumberSum(new int[]{12,3,1,2,-6,5,-8,6}, 0));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<Integer[]>();

        for(int i = 0; i<array.length; i++){
            int subTarget = targetSum - array[0];
            Integer[] subTargetArray = subTarget(array, i, subTarget);
            if(subTargetArray != null){
                subTargetArray[2] = array[i];
                result.add(subTargetArray);
            }
        }

        return result;
    }

    private static Integer[] subTarget(int[] array, int start, int target){
        Set<Integer> seen = new HashSet();
        Integer[] result = new Integer[3];
        for(start = start + 1; start < array.length; start++){
            int need = target - array[start];
            if(seen.contains(need)){
                result[0] = array[start];
                result[1] = need;
                return result;
            }else{
                seen.add(array[start]);
            }
        }

        return null;
    }
}
