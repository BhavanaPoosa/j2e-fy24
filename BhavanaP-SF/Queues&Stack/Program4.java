import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class program4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the LRU Cache: ");
        int capacity = scanner.nextInt();

        LRUCache lruCache = new LRUCache(capacity);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Get value by key");
            System.out.println("2. Set value for key");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key: ");
                    int getKey = scanner.nextInt();
                    int getValue = lruCache.get(getKey);
                    System.out.println("Value for key " + getKey + ": " + getValue);
                    break;
                case 2:
                    System.out.print("Enter the key: ");
                    int setKey = scanner.nextInt();
                    System.out.print("Enter the value: ");
                    int setValue = scanner.nextInt();
                    lruCache.set(setKey, setValue);
                    System.out.println("Value " + setValue + " set for key " + setKey);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            System.out.println();
        }
    }
}

class LRUCache {
    static Node head;
    static Node tail;
    static Map<Integer, Node> map = new HashMap<>();
    static int capacity;

    LRUCache(int cap) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        map = new HashMap<>();
        capacity = cap;
        head.next = tail;
        tail.prev = head;
    }

    public static int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public static void set(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (capacity == map.size()) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private static void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}

class Node {
    Node prev;
    Node next;
    int key, value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
