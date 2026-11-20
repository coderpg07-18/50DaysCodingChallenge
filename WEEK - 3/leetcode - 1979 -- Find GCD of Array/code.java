public class code {

    public int findGCD(int[] nums) {

        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return gcd(min, max);
    }

    public int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {

        code output = new code();

        int n = 5;

        int nums[] = {7, 5, 6, 8, 3};

        int result = output.findGCD(nums);

        System.out.println("GCD of minimum and maximum: " + result);
    }
}
