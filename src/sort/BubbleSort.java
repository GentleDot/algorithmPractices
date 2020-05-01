package sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
    private static final Logger log = LoggerFactory.getLogger(BubbleSort.class);
    public static void main(String[] args) {

        int[] ints = {8, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(sort(ints)));
        System.out.println(Arrays.toString(sortWithCollectionSwap(ints)));
    }

    public static int[] sort(int[] array) {
        long start = System.currentTimeMillis();
        log.debug("시작 : {}", start);
        boolean noSwaps;

        int length = array.length;
        for (int i = length; i > 0; i--) {
            noSwaps = true;
            for (int j = 0; j < (i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    noSwaps = false;
                }
            }
            if (noSwaps){
                break;
            }
        }

        long end = System.currentTimeMillis();
        log.debug("소요 시간(ms) : {}(종료 : {})",end - start, end);
        return array;
    }

    public static int[] sortWithCollectionSwap(int[] array) {
        long start = System.currentTimeMillis();
        log.debug("시작 : {}", start);
        int length = array.length;
        List<Integer> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        for (int i = length; i > 0; i--) {
            for (int j = 0; j < (i - 1); j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        int[] ints = list.stream().mapToInt(i -> i).toArray();
        long end = System.currentTimeMillis();
        log.debug("소요 시간(ms) : {}(종료 : {})",end - start, end);
        return ints;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
