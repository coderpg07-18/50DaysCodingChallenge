
public class code {

    public String convertToTitle(int columnNumber) {

        StringBuilder res = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            int remainder = columnNumber % 26;

            res.append((char) ('A' + remainder));

            columnNumber /= 26;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {

        code output = new code();

        int columnNumber = 20;

        String result = output.convertToTitle(columnNumber);

        System.out.println("Excel Column Title: " + result);
    }
}
