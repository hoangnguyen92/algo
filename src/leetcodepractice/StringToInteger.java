package leetcodepractice;

import java.util.Stack;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("2147483648"));
    }

    /**
     * Example 1:
     * <p>
     * Input: "42"
     * Output: 42
     * Example 2:
     * <p>
     * Input: "   -42"
     * Output: -42
     * Explanation: The first non-whitespace character is '-', which is the minus sign.
     * Then take as many numerical digits as possible, which gets 42.
     * Example 3:
     * <p>
     * Input: "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     * Example 4:
     * <p>
     * Input: "words and 987"
     * Output: 0
     * Explanation: The first non-whitespace character is 'w', which is not a numerical
     * digit or a +/- sign. Therefore no valid conversion could be performed.
     * Example 5:
     * <p>
     * Input: "-91283472332"
     * Output: -2147483648
     * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
     * Thefore INT_MIN (−231) is returned.
     */

    public static int getLengthOfLongestSubstring(String str) {
        str = str.trim();
        Stack<Character> stack = new Stack<>();
        boolean isNegative = false;
        for (int i = 0; i < str.length(); i++) {
            Character c = Character.valueOf(str.charAt(i));
            boolean isNumber = isNumber(c);

            if (stack.empty() && !isNumber && c != '-' && c != '+') {
                return 0;
            }

            if (!stack.empty() && !isNumber) {
                break;
            }

            if (c == '-') {
                isNegative = true;
            }

            if (isNumber) {
                stack.push(c);
            }
        }

        int exponent = 0;
        int result = 0;

        while (!stack.empty()) {
            int currentDigit = Integer.valueOf(stack.pop() - '0');
            result += currentDigit * Double.valueOf(Math.pow(10, exponent)).intValue();
            exponent++;

            if (result < 0) {
                return Integer.MIN_VALUE;
            }
        }

        if (isNegative) {
            return result * -1;
        }

        return result;
    }

    private static boolean isNumber(Character c) {
        return c <= '9' && c >= '0';
    }
}
