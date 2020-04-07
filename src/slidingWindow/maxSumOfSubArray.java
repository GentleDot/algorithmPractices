package slidingWindow;

public class maxSumOfSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{1, 2, 5, 2, 8, 1, 5}, 2));              // 10
        System.out.println(maxSubarraySum(new int[]{1, 2, 5, 2, 8, 1, 5}, 4));              // 17
        System.out.println(maxSubarraySum(new int[]{4, 2, 1, 6}, 1));                       // 6
        System.out.println(maxSubarraySum(new int[]{4, 2, 1, 6, 2}, 4));                    // 13
        System.out.println(maxSubarraySum(new int[]{}, 4));                                 // null
        System.out.println(maxSubarraySumRefactored(new int[]{1, 2, 5, 2, 8, 1, 5}, 2));    // 10
        System.out.println(maxSubarraySumRefactored(new int[]{1, 2, 5, 2, 8, 1, 5}, 4));    // 17
        System.out.println(maxSubarraySumRefactored(new int[]{4, 2, 1, 6}, 1));             // 6
        System.out.println(maxSubarraySumRefactored(new int[]{4, 2, 1, 6, 2}, 4));          // 13
        System.out.println(maxSubarraySumRefactored(new int[]{}, 4));                       // null
    }

    public static Integer maxSubarraySum(int[] arr, int subarraySize) {
        if (arr.length < subarraySize) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < (arr.length - subarraySize) + 1; i++) {
            int temp = 0;
            for (int j = 0; j < subarraySize; j++) {
                temp += (arr[i + j]);
            }

            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static Integer maxSubarraySumRefactored(int[] arr, int subarraySize) {
        // arr의 크기가 지정한 size보다 작으면 null을 출력
        int length = arr.length;
        if (length < subarraySize) {
            return null;
        }

        // arr의 index 0부터 size까지의 합 tempSum을 산출
        int maxSum = 0;
        int tempSum = 0;
        for (int i = 0; i < subarraySize ; i++) {
            tempSum += arr[i];
        }

        // tempSum을 maxSum으로 설정
        maxSum = tempSum;

        // arr의 index[size] 부터 출발해서 maxSum을 확인
            // tempSum의 첫 index는 빼고, size부터의 index 값은 추가
        for (int i = subarraySize; i < length ; i++) {
            tempSum = (tempSum - arr[i - subarraySize]) + arr[i];
            maxSum = Math.max(tempSum, maxSum);
        }

        // maxSum 값을 출력
        return maxSum;
    }
}
