import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Program8 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(String s, int index, List<String> ds, List<List<String>> ans) {
        if (s.isEmpty()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String current = s.substring(0, i + 1);
            if (isPalindrome(current)) {
                ds.add(current);
                helper(s.substring(i + 1), index + 1, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scanner.nextLine();

        Program8 program = new Program8();
        List<List<String>> partitions = program.partition(str);

        System.out.println("Partitions:");
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }

        scanner.close();
    }
}
