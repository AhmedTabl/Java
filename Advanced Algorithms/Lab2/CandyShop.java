import java.util.Scanner;

public class CandyShop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Number of candies
        int[] values = new int[N]; // Sentimental values
        int[] weights = new int[N]; // Weights of the candies

        // Reading sentimental values
        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
        }

        // Reading weights
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        int W = sc.nextInt(); // Maximum weight that can be carried

        // DP array where dp[i][j] represents the maximum sentimental value achievable
        // with the first i candies and maximum weight j
        int[][] dp = new int[N + 1][W + 1];

        // Fill the DP table
        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The answer is the maximum sentimental value we can achieve with all N candies and weight limit W
        System.out.println(dp[N][W]);

        sc.close();
    }
}
