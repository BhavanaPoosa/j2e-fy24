import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the linked list (enter -1 to end):");
        ListNode head = createLinkedList(scanner);

        head = swapPairs(head);

        System.out.println("Linked List after swapping nodes in pairs:");
        printLinkedList(head);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
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

        ListNode(int val) {
            this.val = val;
        }
    }
}
