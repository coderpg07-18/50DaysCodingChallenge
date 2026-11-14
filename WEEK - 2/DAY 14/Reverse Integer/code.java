// LeetCode Problem: 7 Soln...

public class code {

    public static int reverse(int x) {

        int reverse = 0;

        while (x != 0) {

            int lastDigit = x % 10;

            if ((reverse > Integer.MAX_VALUE / 10) || (reverse < Integer.MIN_VALUE / 10)) {
                
                return 0;
            }

            reverse = (reverse * 10) + lastDigit;
            
            x = x / 10;
        }
        
        return reverse;
    }

    public static void main(String[] args) {

        int num = -321;

        System.out.println(reverse(num));
    }
}