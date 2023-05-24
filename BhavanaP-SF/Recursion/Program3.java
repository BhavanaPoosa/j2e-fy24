import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Program3 {
    public static ListNode createLinkedList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHalf = prev;

        // Merge the first and second halves of the list
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode next1 = firstHalf.next;
            ListNode next2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = next1;
            firstHalf = next1;
            secondHalf = next2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        ListNode head = createLinkedList(nums);

        reorderList(head);

        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
