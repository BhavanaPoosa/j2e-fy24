import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;

public class program6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Solution solution = new Solution();
        boolean isValid = solution.isValid(input);

        System.out.println("Is valid: " + isValid);
    }
}

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> Hmap = new HashMap<Character, Character>();
        Hmap.put(')', '(');
        Hmap.put('}', '{');
        Hmap.put(']', '[');

        Stack<Character> stack = new Stack<Character>();

        for (int idx = 0; idx < s.length(); idx++) {
            char c = s.charAt(idx);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || Hmap.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
