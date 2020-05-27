package leetcodepractice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Example 1:
     * <p>
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * <p>
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * <p>
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public int getLengthOfLongestSubstring(String s) {
        Set<Character> uniqueChars = new HashSet();
        int startIndex = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!uniqueChars.contains(s.charAt(i))) {
                uniqueChars.add(s.charAt(i));
                max = Math.max(max, uniqueChars.size());
            } else {
                uniqueChars.remove(s.charAt(startIndex));
                startIndex++;
                i--;
            }
        }

        return max;
    }
}
