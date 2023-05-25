import java.util.HashMap;
import java.util.Scanner;

public class Program6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the LRUCache: ");
        int capacity = scanner.nextInt();

        LRUCache lruCache = new LRUCache(capacity);

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Get");
            System.out.println("2. Put");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            int key, value;

            switch (choice) {
                case 1:
                    System.out.print("Enter the key: ");
                    key = scanner.nextInt();
                    int result = lruCache.get(key);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    System.out.print("Enter the key: ");
                    key = scanner.nextInt();
                    System.out.print("Enter the value: ");
                    value = scanner.nextInt();
                    lruCache.put(key, value);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    class Node {
        Node prev, next;
        int key, value;

        Node(int _key, int _val) {
            key = _key;
            value = _val;
        }
    }
}
