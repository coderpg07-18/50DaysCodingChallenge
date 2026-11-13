
class code {

    public int arraySign(int[] nums) {

        int negativeCount = 0;

        for (int num : nums) {

            if (num == 0) {
                return 0;
            }

            if (num < 0) {
                negativeCount++;
            }
        }

        if (negativeCount % 2 == 0) {
            return 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        code output = new code();

        int[] nums = {1, -2, 3, -4, -5};

        int result = output.arraySign(nums);

        System.out.println("Product Sign: " + result);
    }
}
