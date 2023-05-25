import java.util.Scanner;

public class Program7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the circular deque: ");
        int capacity = scanner.nextInt();

        MyCircularDeque circularDeque = new MyCircularDeque(capacity);

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. InsertFront");
            System.out.println("2. InsertLast");
            System.out.println("3. DeleteFront");
            System.out.println("4. DeleteLast");
            System.out.println("5. GetFront");
            System.out.println("6. GetRear");
            System.out.println("7. IsEmpty");
            System.out.println("8. IsFull");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            int value;
            boolean result;

            switch (choice) {
                case 1:
                    System.out.print("Enter the value: ");
                    value = scanner.nextInt();
                    result = circularDeque.insertFront(value);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    System.out.print("Enter the value: ");
                    value = scanner.nextInt();
                    result = circularDeque.insertLast(value);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = circularDeque.deleteFront();
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result = circularDeque.deleteLast();
                    System.out.println("Result: " + result);
                    break;
                case 5:
                    int front = circularDeque.getFront();
                    System.out.println("Front: " + front);
                    break;
                case 6:
                    int rear = circularDeque.getRear();
                    System.out.println("Rear: " + rear);
                    break;
                case 7:
                    boolean isEmpty = circularDeque.isEmpty();
                    System.out.println("Is Empty: " + isEmpty);
                    break;
                case 8:
                    boolean isFull = circularDeque.isFull();
                    System.out.println("Is Full: " + isFull);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class MyCircularDeque {
    private int[] q;
    private int front;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        q = new int[k];
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            front = (front - 1 + capacity) % capacity;
        }
        q[front] = value;
        ++size;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        int idx = (front + size) % capacity;
        q[idx] = value;
        ++size;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        --size;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        --size;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return
