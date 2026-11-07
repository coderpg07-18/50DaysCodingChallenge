
import java.util.*;

class leetcode_66_plus_one {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] soln = new int[digits.length + 1];
        soln[0] = 1;

        return soln;
    }

    public static void main(String[] args) {

        leetcode_66_plus_one p1 = new leetcode_66_plus_one();

        int[] digits = {9, 9, 9};

        int[] res = p1.plusOne(digits);

        System.out.println(Arrays.toString(res));
    }
}
