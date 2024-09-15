import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {

    public static void main(String[] args) {
        int[] A = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = A.length;

        int[] dp = new int[n]; // dp[i] will be the length of LIS ending at index i
        int[] prev = new int[n]; // prev[i] will store the index of the previous element in the LIS ending at index i
        Arrays.fill(dp, 1); // Initialize all lengths to 1
        Arrays.fill(prev, -1); // Initialize all previous indices to -1

        int maxLength = 1; // Length of the longest increasing subsequence found so far
        int endIndex = 0; // The index of the last element in the longest increasing subsequence

        // Fill dp and prev arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // Update the maxLength and endIndex if a longer LIS is found
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }

        // Reconstruct the LIS
        List<Integer> lis = new ArrayList<>();
        for (int i = endIndex; i >= 0; i = prev[i]) {
            lis.add(0, A[i]);
            if (prev[i] == -1) break;
        }

        // Print the LIS and its length
        System.out.println("Length of LIS: " + maxLength);
        System.out.println("LIS: " + lis);
    }
}
