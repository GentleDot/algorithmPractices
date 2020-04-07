package divideAndConquer;

import java.util.Arrays;
import java.util.Collections;

public class SearchInArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3,4,5,6},4)); // 3
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6},4)); // 3
    }

    public static int search(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) {
            return -1;
        }

        for (int i = 0; i < length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        // arr의 크기가 0이면 -1 반환
        int length = arr.length;
        if (length == 0) {
            return -1;
        }

        // arr를 오름차순 정렬
        Arrays.sort(arr);

        // arr의 시작 index인 startIdx와 arr의 종료 index인 endIdx를 설정
        int startIdx = 0;
        int endIdx = length - 1;

        // startIdx값이 endIdx보다 크지 않는 동안 startIdx + endIdx의 중간 index인 middle을 구하고
            // arr[middle] 값이 target 값보다 크면 endIdx를 (middle - 1)로 설정
            // arr[middle] 값이 target 값보다 작으면 startIndx를 (middle + 1)로 설정
            // arr[middle] 값이 target 값과 같다면 middle 값을 반환

        while (startIdx <= endIdx) {
            int middle = (startIdx + endIdx) / 2;
            int currentValue = arr[middle];

            if (currentValue > target){
                endIdx = (middle - 1);
            }else if (currentValue < target){
                startIdx = (middle + 1);
            }else{
                return middle;
            }
        }

        return -1;
    }
}
