package howToSolve.sort.efficientSort;

import static howToSolve.Main.log;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(pivot(new int[]{4, 8, 2, 1, 5, 7, 6, 3}, null, null));
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
