package problems.sort;

public class CountInversion {
    public static void main(String[] args) {

    }

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        int length = arr.length;
        int temp;
        long result = 0;

        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                int currentNum = arr[j];
                int beforeNum = arr[j - 1];
                if (currentNum < beforeNum) {
                    temp = currentNum;
                    arr[j] = beforeNum;
                    arr[j - 1] = currentNum;
                    result++;
                }
            }
        }

        return result;
    }
}
