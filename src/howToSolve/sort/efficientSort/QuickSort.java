package howToSolve.sort.efficientSort;

import java.util.Arrays;

import static howToSolve.Main.log;

public class QuickSort {
    public static void main(String[] args) {
//        System.out.println(pivot(new int[]{4, 8, 2, 1, 5, 7, 6, 3}, null, null));
        System.out.println(Arrays.toString(quickSort(new int[]{4, 6, 9, 1, 2, 5, 3}, null, null)));
//        System.out.println(Arrays.toString(quickSort(new int[]{100, -3, 4, 6, 9, 1, 2, 5, 3}, null, null)));
    }

    public static int[] quickSort(int[] array, Integer left, Integer right) {
        int length = array.length;

        // left와 right가 지정되지 않은 경우 left = 0, right = (length - 1) 로 설정
        if (left == null) {
            left = 0;
        }
        if (right == null) {
            right = length - 1;
        }

        // pivot index를 기준으로
            // 좌측은 start index보다 (pivot index - 1)이 큰 경우 정렬 진행
            // 우측은 pivot index + 1 보다 end index가 큰 경우 정렬 진행
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            log.debug("pivot index : {}, pivot = {}", pivotIndex, array[pivotIndex]);
            log.debug("left index : {}, left = {}", left, array[left]);
            log.debug("right index : {}, right = {}", right, array[right]);

            // left 정렬
            quickSort(array, left, pivotIndex - 1);
            log.debug("left 정렬 후 array : {}", array);
            // right 정렬
            quickSort(array, pivotIndex + 1, right);
            log.debug("right 정렬 후 array : {}", array);
        }

        return array;
    }

    // 배열, 배열의 시작 index, 배열의 종료 index를 parameter로 전달 받음
    // null 설정을 위해 Integer로 Boxing
    public static int pivot(int[] array, Integer start, Integer end) {
        // 배열의 길이 확인
        int length = array.length;

        // start와 end가 지정되지 않는 경우 start = 0, end = (length - 1) 로 설정
        if (start == null) {
            start = 0;
        }
        if (end == null) {
            end = length - 1;
        }

        // 배열의 시작 index 값을 pivot으로 설정
        int pivot = array[start];
        // pivot index를 변수에 저장
        int swapIndex = start;

        // 배열의 처음 index부터 종료 index까지 loop 진행
        for (int i = start + 1; i <= end; i++) {
            // pivot이 탐색 중인 값보다 큰 경우
            // pivot index += 1
            // 탐색 된 값과 pivot 값을 swap
            if (pivot > array[i]) {
                swapIndex++;
                swap(array, swapIndex, i);
                log.debug("현재 배열 : {}", array);
            }
        }
        // 시작 index 값과 pivot index 값과 swap
        swap(array, start, swapIndex);
        log.debug("최종적으로 swap 된 배열 : {}", array);

        // pivot index를 반환
        return swapIndex;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
