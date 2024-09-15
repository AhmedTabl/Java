import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // Length of rod
        int[] prices = new int[N + 1]; // Prices

        // Reading prices
        for (int i = 1; i <= N; i++) {
            prices[i] = sc.nextInt();
        }

        int[] dp = new int[N + 1];

        // Fill the DP table
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                dp[j] = Math.max(dp[j], dp[j - i] + prices[i]);
            }
        }

        System.out.println(dp[N]);

        sc.close();
    }
}
