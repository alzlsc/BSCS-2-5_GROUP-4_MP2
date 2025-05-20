import java.util.*;

public class optKnapsack {

    static class Item {
        int value, weight;
        double score;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.score = (double) value / weight;
        }
    }

    static int maxWeight; 
    static int bestValue = 0;  
    static Item[] items;  

    static boolean[] currChosen;
    static boolean[] bestChosen;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int index = scanner.nextInt();

        items = new Item[index];

        currChosen = new boolean[index];
        bestChosen = new boolean[index];

        for (int i = 0; i < index; i++) {
            System.out.print("Enter value for item " + (i + 1) + ": ");
            int value = scanner.nextInt();

            System.out.print("Enter weight for item " + (i + 1) + ": ");
            int weight = scanner.nextInt();

            items[i] = new Item(value, weight);
        }
    
        System.out.print("Enter maximum weight the knapsack can carry: ");
        maxWeight = scanner.nextInt();
    
        Arrays.sort(items, Comparator.comparing(Item->Item.score));

        Optimal(0, 0, 0);

        System.out.println("Best total value that fits: " + bestValue);
        System.out.println("Items included in the best combination: ");
        
        for (int i = 0; i < bestChosen.length; i++) {
            if (bestChosen[i]) {
                System.out.println("Item " + (i + 1) + ": value = " + items[i].value + ", weight = " + items[i].weight);
            }
        }
    }

    static void Optimal(int index, int currWeight, int currValue) {
        if (currWeight > maxWeight) return;

        if(currValue>bestValue){
            bestValue=currValue;
            bestChosen = Arrays.copyOf(currChosen, currChosen.length);
        }

        for (int i = index; i < items.length; i++) {
            currChosen[i] = true;
            Optimal(i + 1, currWeight + items[i].weight, currValue + items[i].value);
            currChosen[i] = false;
        }
    }
}