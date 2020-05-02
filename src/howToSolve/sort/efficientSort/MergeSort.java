package howToSolve.sort.efficientSort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 10, 50}, new int[]{2, 14, 99, 100})));
        System.out.println(Arrays.toString(merge(new int[]{100, 200}, new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(merge(new int[]{}, new int[]{1, 2, 3})));
    }

    public static int[] merge(int[] array1, int[] array2) {
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

            /*int min = Math.min(itemInArr1, itemInArr2);
            resultsList.add(min);*/

            /*if (min == itemInArr1) {
                i++;
            } else {
                j++;
            }*/
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
