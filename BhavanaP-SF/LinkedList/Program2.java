import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the first sorted list (enter -1 to end):");
        ListNode l1 = createLinkedList(scanner);

        System.out.println("Enter the elements of the second sorted list (enter -1 to end):");
        ListNode l2 = createLinkedList(scanner);

        ListNode mergedList = mergeTwoLists(l1, l2);

        System.out.println("Merged List:");
        printLinkedList(mergedList);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        ListNode temp;
        if (l1.val < l2.val) {
            temp = head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            temp = head = new ListNode(l2.val);
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = new ListNode(l1.val);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = new ListNode(l2.val);
            l2 = l2.next;
            temp = temp.next;
        }
        return head;
    }

    public static ListNode createLinkedList(Scanner scanner) {
        System.out.println("(Enter -1 to end):");

        ListNode head = null;
        ListNode current = null;

        while (true) {
            int value = scanner.nextInt();
            if (value == -1) {
                break;
            }

            ListNode newNode = new ListNode(value);
            if (head == null) {
                head = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
