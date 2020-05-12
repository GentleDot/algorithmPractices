package howToSolve.sort.nonComparisonSort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static howToSolve.Main.log;

public class CountingSort {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sortWithCollection(new int[]{2, 3, 8, 7, 1, 2, 2, 2, 7, 3, 9, 8, 2, 1, 4, 2, 4, 6, 9, 2})));
        System.out.println(Arrays.toString(sort(new int[]{2, 3, 8, 7, 1, 2, 2, 2, 7, 3, 9, 8, 2, 1, 4, 2, 4, 6, 9, 2})));

    }

    public static int[] sortWithCollection(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        list.sort(Integer::compareTo);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] sort(int[] array) {
        // 정렬 가능한 숫자를 상수로 설정
        int constNumber = 10;
        int length = array.length;

        // 배열 길이가 1 이하인 경우 배열을 그대로 반환
        if (length <= 1){
            return array;
        }

        // 계수를 담을 배열 countingArr 생성
        int[] countingArr = new int[constNumber];

        // countingArr에 요소의 계수를 입력
        for (int item : array) {
            countingArr[item] += 1;
        }
        log.debug("counting 결과 : {}", countingArr);

        // 결과 배열 생성
        int[] result = new int[length];

        // 전달 받은 배열의 길이만큼 새 배열 result를 만들고 요소를 차례대로 넣어 정렬된 배열을 생성
        int j = 1;
        int insertCount = 0;
        for (int i = 0; i < length ; i++) {
            int itemQuantity = countingArr[j];

            // 계수가 0인 경우에 result에 값을 담지 않고 다음 index (index + 1)의 계수를 확인
            if (itemQuantity == 0){
                j++;
                i--;
                continue;
            }

            // index i 값을 result 배열에 순서대로 입력
                // 입력 후에는 카운트 + 1
            result[i] = j;
            insertCount++;

            // 계수와 입력 카운트를 비교하여 계수만큼 입력이 이뤄지면 다음 계수로 진행
            if (insertCount == itemQuantity){
                j++;
                insertCount = 0;
            }
        }

        return result;
    }
}
