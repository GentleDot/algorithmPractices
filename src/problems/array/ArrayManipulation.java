package problems.array;

import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long resultArr[] = new long[n + 2];
        for (int i = 0; i < queries.length; i++) {
            int startIdx = queries[i][0];
            int endIdx = queries[i][1];
            int value = queries[i][2];

            resultArr[startIdx] += value;
            resultArr[endIdx + 1] -= value;
        }
        return getMax(resultArr);
    }

    private static long getMax(long[] inputArr) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < inputArr.length; i++) {
            sum += inputArr[i];
            max = Math.max(max, sum);
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        scanner.close();
    }
}

