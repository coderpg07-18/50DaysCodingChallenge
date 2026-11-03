
class leetcode_507_perfect_number {

    public boolean checkPerfectNumber(int num) {

        int sum = 0;
        
        for (int i = 1; i <= num / 2; i++) {

            if (num % i == 0) {
                sum += i;
            }
            if(sum > num) {
                return false;
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {

        leetcode_507_perfect_number obj = new leetcode_507_perfect_number();

        int num = 28;

        boolean result = obj.checkPerfectNumber(num);

        System.out.println("Perfect Number: " + result);
    }
}
