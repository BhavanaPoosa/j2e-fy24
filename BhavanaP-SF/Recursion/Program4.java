import java.util.*;

class Program4 {
    public static void towersOfHanoi(int n, int source, int destination, int auxiliary) {
        if (n == 1) {
            System.out.println("Move disk from rod " + source + " to rod " + destination);
            return;
        }

        towersOfHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk from rod " + source + " to rod " + destination);
        towersOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        towersOfHanoi(n, 1, 3, 2);
    }
}
