package howToSolve.dynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

import static howToSolve.Main.log;

public class Fibonacci {

    public static void main(String[] args) {
        int targetNum = 5;
        System.out.println(fibWithMemoizedSolution(targetNum, new Integer[targetNum + 1]));
        System.out.println(fibWithTabulatedSolution(targetNum));
    }

    public static Integer fibWithMemoizedSolution(Integer n, Integer[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }
        if (n <= 2) {
            memo[n] = 1;
            return 1;
        }

        int item = fibWithMemoizedSolution(n - 1, memo) + fibWithMemoizedSolution(n - 2, memo);
        memo[n] = item;

        log.info("memo 배열 확인 : {}", Arrays.toString(memo));
        return item;
    }

    public static Integer fibWithTabulatedSolution(Integer n) {
        if (n <= 2) {
            return 1;
        }

        int[] fibTab = new int[n + 1];
        Array.set(fibTab, 0, 0);
        Array.set(fibTab, 1, 1);
        Array.set(fibTab, 2, 1);

        for (int i = 3; i <= n; i++) {
            fibTab[i] = fibTab[i - 2] + fibTab[i - 1];
        }

        log.info("fibTab 확인 : {}", fibTab);
        return fibTab[n];
    }
}
