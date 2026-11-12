
class code {

    public int countOdds(int low, int high) {

        return (high + 1) / 2 - low / 2;
    }

    public static void main(String[] args) {

        code output = new code();

        int low = 5;

        int high = 13;

        int res = output.countOdds(low, high);

        System.out.println("Count of Odd Numbers: " + res);
    }
}
