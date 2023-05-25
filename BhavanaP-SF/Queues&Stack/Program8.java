import java.util.Scanner;

public class Program8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Solution solution = new Solution();
        String result = solution.removeDuplicates(input);

        System.out.println("String after removing duplicates: " + result);
    }
}

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder se = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (se.length() > 0 && se.charAt(se.length() - 1) == s.charAt(i)) {
                se.deleteCharAt(se.length() - 1);
            } else {
                se.append(s.charAt(i));
            }
        }

        return se.toString();
    }
}
