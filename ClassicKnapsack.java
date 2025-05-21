import java.util.Scanner;

public class ClassicKnapsack{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int intSize = scanner.nextInt();

        int[] intValues = new int[intSize];
        int[] intWeights = new int[intSize];

        for (int i = 0; i < intSize; i++){
            System.out.print("Enter value for item " +(i + 1)+ ": ");
            intValues[i] = scanner.nextInt();

            System.out.print("Enter weight for item " +(i + 1)+ ": ");
            intWeights[i] = scanner.nextInt();
        }

        System.out.print("Enter maximum weight capacity: ");
        int intCapacity = scanner.nextInt();

        int[][] dp = new int[intSize + 1][intCapacity + 1];
        for (int i = 1; i <= intSize; i++) {
            for (int w = 0; w <= intCapacity; w++) {
                if (intWeights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], intValues[i - 1] + dp[i - 1][w - intWeights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Best total value that fits: " +dp[intSize][intCapacity]);
        System.out.println("Items included in the best combination:");

        int w = intCapacity;
        for (int i = intSize; i > 0 && w > 0; i--){
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println("Item " +i+ ": value = "+intValues[i - 1]+ ", weight = " +intWeights[i - 1]);
                w -= intWeights[i - 1];
            }
        }

        scanner.close();
    }
}
