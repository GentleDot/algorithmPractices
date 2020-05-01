package howToSolve.sort;

import java.util.Arrays;

import static howToSolve.Main.log;

public class InsertionSort {
    public static void main(String[] args) {
        int[] ints = {2, 1, 9, 76, 4};
        System.out.println(Arrays.toString(sort(ints)));
    }

    public static int[] sort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            log.debug("현재 index : {}", i);
            int j;
            int currentValue = array[i];
            for (j = (i - 1); j >= 0 && array[j] > currentValue; j--) {
                array[j + 1] = array[j];
                log.debug("--------- 내부 loop index : {}, 배열 : {}", j, array);
            }
            log.debug("---- loop 종료 index + 1 : {}, currentValue : {}", j + 1, currentValue);
            array[j + 1] = currentValue;
            log.debug("----위치 조정된 배열 : {}", array);
        }
        return array;
    }
}
