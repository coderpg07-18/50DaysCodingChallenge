
class leetcode_258_add_digits {

    public int addDigits(int num) {

        while (num >= 10) {
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }

    public static void main(String[] args) {

        int num = 15;

        leetcode_258_add_digits obj = new leetcode_258_add_digits();

        int result = obj.addDigits(num);

        System.out.println("Single Digit Sum: " + result);
    }
}

