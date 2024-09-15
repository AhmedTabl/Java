import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Function to perform Rabin-Karp algorithm
    public static List<Integer> rabinKarp(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int prime = 101; // A prime number
        int hashText = 0; // Hash value for text
        int hashPattern = 0; // Hash value for pattern
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (int i = 0; i < m - 1; i++)
            h = (h * 256) % prime;

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < m; i++) {
            hashPattern = (256 * hashPattern + pattern.charAt(i)) % prime;
            hashText = (256 * hashText + text.charAt(i)) % prime;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {

            // Check the hash values of current window of text and pattern
            if (hashPattern == hashText) {
                // Check for characters one by one
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(i);
                }
            }

            // Calculate hash value for next window of text: Remove leading digit,
            // add trailing digit
            if (i < n - m) {
                hashText = (256 * (hashText - text.charAt(i) * h) + text.charAt(i + m)) % prime;

                // We might get negative value of t, converting it to positive
                if (hashText < 0)
                    hashText = (hashText + prime);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the text: ");
            String text = scanner.nextLine();
            System.out.println("Enter the pattern: ");
            String pattern = scanner.nextLine();

            List<Integer> positions = rabinKarp(text, pattern);

            if (positions.isEmpty()) {
                System.out.println("Pattern " + pattern + " not found");
            } else {
                for (Integer position : positions) {
                    System.out.println("Pattern " + pattern + " found at index " + position);
                }
            }

            System.out.println("Do you want to search another pattern? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }
}
