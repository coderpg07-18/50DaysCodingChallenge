
class code {

    public int titleToNumber(String columnTitle) {

        int soln = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            int value = columnTitle.charAt(i) - 'A' + 1;

            soln = soln * 26 + value;
        }

        return soln;
    }

    public static void main(String[] args) {

        String columnTitle = "ZY";

        code obj = new code();

        int res = obj.titleToNumber(columnTitle);

        System.out.println("Column Number: " + res);
    }
}
