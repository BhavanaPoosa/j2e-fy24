import java.util.Scanner;

public class program10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of tokens: ");
        int n = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        String[] tokens = new String[n];

        System.out.println("Enter the tokens:");
        for (int i = 0; i < n; i++) {
            tokens[i] = scanner.nextLine();
        }

        int result = eval(tokens);
        System.out.println("Result: " + result);
    }

    public static int eval(String[] tokens) {
        int i = 0;
        int lastNum = -1;

        while (i < tokens.length) {
            if ("/*+-".contains(tokens[i])) {
                int val1 = Integer.valueOf(tokens[lastNum - 1]);
                int val2 = Integer.valueOf(tokens[lastNum]);
                int ans = 0;

                if (tokens[i].equals("*"))
                    ans = val1 * val2;
                else if (tokens[i].equals("/"))
                    ans = val1 / val2;
                else if (tokens[i].equals("+"))
                    ans = val1 + val2;
                else if (tokens[i].equals("-"))
                    ans = val1 - val2;

                tokens[lastNum - 1] = Integer.toString(ans);
                lastNum--;
            } else {
                lastNum++;
                tokens[lastNum] = tokens[i];
            }
            i++;
        }

        return Integer.valueOf(tokens[lastNum]);
    }
}
