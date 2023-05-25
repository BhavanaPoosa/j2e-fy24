import java.util.Scanner;
import java.util.Stack;

public class program2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackQueue stackQueue = new StackQueue();

        // User input loop
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int value = scanner.nextInt();
                    stackQueue.Push(value);
                    System.out.println("Value pushed successfully.");
                    break;
                case 2:
                    int poppedValue = stackQueue.Pop();
                    if (poppedValue == -1) {
                        System.out.println("Stack is empty. Cannot pop.");
                    } else {
                        System.out.println("Popped value: " + poppedValue);
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}

class StackQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void Push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int Pop() {
        if (s1.isEmpty())
            return -1;
        int x = s1.peek();
        s1.pop();
        return x;
    }
}
