package leetcodepractice;

public class RomanToInteger {
    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * Example 1:
     * <p>
     * Input: "III"
     * Output: 3
     * Example 2:
     * <p>
     * Input: "IV"
     * Output: 4
     * Example 3:
     * <p>
     * Input: "IX"
     * Output: 9
     * Example 4:
     * <p>
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     */
    public static void main(String[] args) {
        int result = convertRomanToInteger("LVIII", 0);
        System.out.println(result);
    }

    private static int convertRomanToInteger(String input, int index) {
        if (index >= input.length()) {
            return 0;
        }

        char currentChar = input.charAt(index);
        char nextChar = index + 1 < input.length() ? input.charAt(index + 1) : '0';
        int result = convertSymbolToInteger(currentChar);

        if (currentChar == 'I' && (nextChar == 'V' || nextChar == 'X')) {
            int currentCharValue = convertSymbolToInteger(currentChar);
            int nextCharValue = convertSymbolToInteger(nextChar);

            result = nextCharValue - currentCharValue;
            index++;
        }

        if (currentChar == 'X' && (nextChar == 'L' || nextChar == 'C')) {
            int currentCharValue = convertSymbolToInteger(currentChar);
            int nextCharValue = convertSymbolToInteger(nextChar);

            result = nextCharValue - currentCharValue;
            index++;
        }

        if (currentChar == 'C' && (nextChar == 'D' || nextChar == 'M')) {
            int currentCharValue = convertSymbolToInteger(currentChar);
            int nextCharValue = convertSymbolToInteger(nextChar);

            result = nextCharValue - currentCharValue;
            index++;
        }

        return result + convertRomanToInteger(input, index + 1);
    }

    private static int convertSymbolToInteger(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
