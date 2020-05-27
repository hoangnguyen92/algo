package leetcodepractice;

public class AddBinary {

    public static void main(String[] args) {

        System.out.println(addBinary("1", "111"));
    }

    public static String addBinary(String a, String b) {
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        for (int i = 0; i < a.length() - b.length(); i++) {
            b = "0" + b;
        }

        int carry = 0;
        String result = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            String add = "" + c1 + c2;
            if (add.equals("10") || add.equals("01")) {
                if (carry == 1) {
                    carry = 1;
                    result = "0" + result;
                } else {
                    carry = 0;
                    result = "1" + result;
                }
            } else if (add.equals("00")) {
                if (carry == 1) {
                    result = "1" + result;
                    carry = 1;
                } else {
                    result = "0" + result;
                }
            } else if (add.equals("11")) {
                result = "0" + result;
                carry = 1;
            }
        }

        if (carry == 1) {
            result = "1" + result;
        }

        return result;
    }
}
