package howToSolve.commonSolvingPattern.multiplePointers;

import java.util.Arrays;

public class PairSumIsZero {
    public static void main(String[] args) {
        sumZero(new int[]{-3, -2, -1, 0, 1, 2, 3}); // [-3,3]
        sumZero(new int[]{-2, 0, 1, 3}); // null
        sumZero(new int[]{1, 2, 3}); // null
        sumZeroRefactored(new int[]{-3, -2, -1, 0, 1, 2, 3}); // [-3,3]
        sumZeroRefactored(new int[]{-2, 0, 1, 3}); // null
        sumZeroRefactored(new int[]{1, 2, 3}); // null

    }

    public static int[] sumZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    int[] result = {arr[i], arr[j]};
                    System.out.println(Arrays.toString(result));
                    return result;
                }
            }
        }
        System.out.println("합이 0이 되는 짝을 찾을 수 없습니다.");
        return null;
//        throw new RuntimeException("합이 0이 되는 짝을 찾을 수 없습니다.");
    }

    public static int[] sumZeroRefactored(int[] arr) {
        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        while (leftIdx < rightIdx) {
            int sum = arr[leftIdx] + arr[rightIdx];

            if (sum == 0) {
                int[] result = {arr[leftIdx], arr[rightIdx]};
                System.out.println(Arrays.toString(result));
                return result;
            } else if (sum > 0) {
                rightIdx--;
            } else {
                leftIdx++;
            }
        }

        System.out.println("합이 0이 되는 짝을 찾을 수 없습니다.");
        return null;
    }

}
