
class leetcode_202_happy_number {

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = sum_Sq(slow);
            fast = sum_Sq(sum_Sq(fast));

        } while (slow != fast);

        return slow == 1;
    }

    public int sum_Sq(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            sum += digit * digit;

            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        leetcode_202_happy_number obj = new leetcode_202_happy_number();

        int n = 25;

        boolean result = obj.isHappy(n);

        System.out.println("Happy Number: " + result);
    }
}
