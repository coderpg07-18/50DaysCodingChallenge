
public class leetcode_09_palindrome_number {

    public static boolean isPalindrome(int n) {

        if (n < 0) {
            return false;
        }

        int originalNum = n;

        int reverse = 0;

        while (n > 0) {

            int lastDigit = n % 10;

            reverse = (reverse * 10) + lastDigit;

            n /= 10;
        }

        return reverse == originalNum;

    }

    public static void main(String[] args) {
        
        int num = 121;

        System.out.println(isPalindrome(num));
    }
}