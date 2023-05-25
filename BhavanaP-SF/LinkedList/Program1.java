import java.util.Scanner;

public class Program1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        ListNode head = createLinkedList(scanner);
        int n = scanner.nextInt();
        head = removeNthFromEnd(head, n);

        printLinkedList(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
       

        return head;
    }


    public static ListNode createLinkedList(Scanner scanner) {
        System.out.println("Enter the elements of the linked list (enter -1 to end):");

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
        System.out.print("Linked List: ");
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
