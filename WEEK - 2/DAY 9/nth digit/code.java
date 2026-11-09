
import java.util.*;

class code {

    public int findNthDigit(int n) {

        long digitLen = 1;
        long countNum = 9;
        long startNum = 1;

        while (n > digitLen * countNum) {

            n -= digitLen * countNum;

            digitLen++;
            countNum *= 10;
            startNum *= 10;
        }

        // The actual number
        long num = startNum + (n - 1) / digitLen;

        int index = (int) ((n - 1) % digitLen);

        String s = String.valueOf(num);

        return s.charAt(index) - '0';
    }

    public static void main(String[] args) {

        code nthDigit = new code();

        int n = 17;

        int output = nthDigit.findNthDigit(n);

        System.out.println("Nth Digit: " + output);
    }
}
