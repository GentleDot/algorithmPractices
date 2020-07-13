package problems.sort;

import java.util.Arrays;

public class MarkAndToys {
    public static void main(String[] args) {
        System.out.println(maximumToys(new int[]{3, 7, 2, 9, 4}, 15));
    }

    // https://www.hackerrank.com/challenges/mark-and-toys/problem
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int length = prices.length;
        int total = 0;
        int result = 0;

        Arrays.sort(prices);

        for (int i = 0; i < length; i++) {
            total += prices[i];
            if (total > k) {
                break;
            }
            result = i + 1;
        }

        return result;
    }
}
