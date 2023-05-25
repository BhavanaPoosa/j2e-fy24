import java.util.Scanner;

public class Program8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input list1
        System.out.println("Enter the elements of list1 separated by spaces:");
        ListNode list1 = createList(scanner.nextLine());

        // Input a and b
        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        scanner.nextLine(); // Consume newline

        // Input list2
        System.out.println("Enter the elements of list2 separated by spaces:");
        ListNode list2 = createList(scanner.nextLine());

        // Merge lists
        Solution solution = new Solution();
        ListNode mergedList = solution.mergeInBetween(list1, a, b, list2);

        // Print merged list
        System.out.println("Merged List:");
        printList(mergedList);
    }

    private static ListNode createList(String input) {
        String[] elements = input.split(" ");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String element : elements) {
            int value = Integer.parseInt(element);
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ret = list1;
        ListNode curr = list1;
        ListNode curr2 = list1;
        while (a > 1) {
            a--;
            curr = curr.next;
        }
        while (b > 0) {
            b--;
            curr2 = curr2.next;
        }
        curr2 = curr2.next;
        curr.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = curr2;
        return ret;
    }
}
