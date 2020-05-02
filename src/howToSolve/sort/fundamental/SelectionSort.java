package howToSolve.sort.fundamental;

import java.util.Arrays;

import static howToSolve.Main.log;

public class SelectionSort {
    public static void main(String[] args) {
        int[] ints = {0, 2, 34, 22, 10, 19, 17};
        System.out.println(Arrays.toString(sort(ints)));
    }

    public static int[] sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int lowest = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[lowest]) {
                    lowest = j;
                }
            }
            log.debug("현재 index : {}", i);
            if (i != lowest) {
                swap(array, i, lowest);
            }
        }
        return array;
    }

    private static void swap(int[] arr, int index1, int index2) {
        log.debug("swap 이전 배열 : {}", arr);
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        log.debug("swap 이후 배열 : {}", arr);
    }
}
