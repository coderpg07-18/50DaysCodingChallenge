
public class leetcode_367_valid_perfect_square {

    public boolean isPerfectSquare(int num) {
        
        for (long i = 1; i * i <= num; i++) {

            if (i * i == num) {
                return true;
            }
        }

        return false;
    }

    public void main(String[] args) {

        int num = 25;

        System.out.println( isPerfectSquare(num) );
    }
}