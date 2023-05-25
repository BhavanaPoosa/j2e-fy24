import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class program1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queues queues = new Queues();

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
                    queues.push(value);
                    System.out.println("Value pushed successfully.");
                    break;
                case 2:
                    int poppedValue = queues.pop();
                    if (poppedValue == -1) {
                        System.out.println("Queue is empty. Cannot pop.");
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

class Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    void push(int a) {
        q2.add(a);

        while (!q1.isEmpty()) {
            q2.add(q1.peek());
            q1.remove();
        }

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    int pop() {
        if (q1.isEmpty())
            return -1;
        return q1.remove();
    }
}
