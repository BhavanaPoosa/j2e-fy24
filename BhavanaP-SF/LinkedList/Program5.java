import java.util.Scanner;

public class Program5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the linked list (enter -1 to end):");
        ListNode head = createLinkedList(scanner);

        head = deleteDuplicates(head);

        System.out.println("Linked List after deleting duplicates:");
        printLinkedList(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;

        if (head == null || head.next == null) {
            return head;
        }

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int value = curr.next.val;
                while (curr.next != null && curr.next.val == value) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
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

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }
    }
}
