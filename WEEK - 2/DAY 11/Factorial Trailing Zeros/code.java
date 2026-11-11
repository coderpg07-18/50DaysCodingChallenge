
class code {

    public int trailingZeroes(int n) {

        int count = 0;

        while (n >= 5) {

            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {

        code cls = new code();

        int n = 25;

        int output = cls.trailingZeroes(n);

        System.out.println("Trailing Zeroes: " + output);
    }
}
