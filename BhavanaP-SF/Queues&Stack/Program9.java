import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StockSpanner stockSpanner = new StockSpanner();

        System.out.print("Enter the number of prices: ");
        int n = scanner.nextInt();

        System.out.println("Enter the prices:");

        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            int span = stockSpanner.next(price);
            System.out.println("Span for price " + price + ": " + span);
        }
    }
}

class StockSpanner {
    List<Integer> list;
    int i;

    public StockSpanner() {
        list = new ArrayList<Integer>();
        i = 0;
    }

    public int next(int price) {
        list.add(i, price);
        int j = i;
        int count = 0;

        while (list.get(j) <= price) {
            if (j == 0) {
                count++;
                break;
            } else {
                count++;
                j--;
            }
        }

        i++;
        return count;
    }
}
