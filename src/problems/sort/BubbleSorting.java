package problems.sort;

public class BubbleSorting {
    public static void main(String[] args) {
        countSwaps(new int[]{4, 2, 3, 1});
    }
    // https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int length = a.length;
        int temp = 0;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    counter++;
                }
            }
        }
        System.out.println(String.format("Array is sorted in %d swaps.", counter));
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }
}
