package problems.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountInversion {
    public static void main(String[] args) {
        System.out.println();
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

    static long countInversions2(int[] arr) {
        long result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
            map2.put(arr[i], map2.getOrDefault(arr[i], 0) + 1);
        }
        int[] sortedArr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortedArr));
        return result;
    }

    static int[] mergeSort(int[] arr){
        int length = arr.length;

        if (length <= 1) {
            return arr;
        }

        int middle = length / 2;
        int[] leftArr = Arrays.copyOfRange(arr, 0, middle);
        int[] rightArr = Arrays.copyOfRange(arr, middle, length);

        int[] sliceLeftArr = mergeSort(leftArr);
        int[] sliceRightArr = mergeSort(rightArr);

        return merge(sliceLeftArr, sliceRightArr);
    }

    static int[] merge(int[] array1, int[] array2) {
        // 전달받은 array length 확인
        // 첫 번째 배열의 길이가 0이라면 두 번째 배열 반환
        // 두 번째 배열의 길이가 0이라면 첫 번째 배열 반환
        int firstArrLength = array1.length;
        int secondArrLength = array2.length;

        if (firstArrLength < 0) {
            return array2;
        } else if (secondArrLength < 0) {
            return array1;
        }

        // 결과를 담을 빈 배열인 결과 배열 생성
        // 병합할 두 배열을 비교하여
        //- 첫 번째 배열 값이 두 번째 배열의 값보다 작은 경우 첫 번째 배열의 값을 결과로 push하고 첫 번째 배열의 다음 값으로 이동
        //- 첫 번째 배열의 값이 두 번째 배열의 값보다 큰 경우 두 번째 배열의 값을 결과로 push하고 두 번째 배열의 다음 값으로 이동
        //- 두 배열 중 한 배열이 소진 된다면 다른 배열의 나머지 값을 모두 push
        ArrayList<Integer> resultsList = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < firstArrLength && j < secondArrLength) {
            int itemInArr1 = array1[i];
            int itemInArr2 = array2[j];

            if (itemInArr1 <= itemInArr2) {
                resultsList.add(itemInArr1);
                i++;
            } else {
                resultsList.add(itemInArr2);
                j++;
            }
        }

        if (i == firstArrLength) {
            for (; j < secondArrLength; j++) {
                resultsList.add(array2[j]);
            }
        } else {
            for (; i < firstArrLength; i++) {
                resultsList.add(array1[i]);
            }
        }

        return resultsList.stream().mapToInt(Integer::intValue).toArray();
    }
}
