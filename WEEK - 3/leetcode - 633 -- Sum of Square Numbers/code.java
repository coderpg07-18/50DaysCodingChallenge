
public class code {

    public boolean judgeSquareSum(int c) {

        long left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right) {

            long sum = left * left + right * right;

            if (sum == c) {
                return true;
            }

            if (sum < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        code output = new code();

        int c = 5;

        boolean result = output.judgeSquareSum(c);

        System.out.println("Can be represented as sum of two squares: " + result);
    }
}
