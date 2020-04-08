package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectOddNumber {
    public static void main(String[] args) {
        OddCollector collector = new OddCollector();
        int[] result = collector.getResult(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(result));
        int[] ints = oddCollectFunc(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] oddCollectFunc(int[] arr){
        // 붙여넣을 int[] 생성
        int[] result = new int[0];

        // arr의 길이가 0이면 arr를 그대로 반환
        if (arr.length == 0){
            return arr;
        }

        // arr의 index 0 값을 가져와 짝수인지 홀수인지 판단
            // 홀수 값이 존재한다면 result = new int[1]로 변경 후 삽입
        int targetNumber = arr[0];
        if(targetNumber % 2 != 0){
            result = new int[1];
            Array.set(result,(result.length - 1), targetNumber);
        }

        // arr 배열에서 index 0 값을 제거한 새로운 배열 removeFirstArr을 복사하여 생성
        int[] removeFirstArr = Arrays.copyOfRange(arr, 1, arr.length);

        // removeFirstArr를 function에 전달하여 recursionArr 배열을 반환 받음. (재귀 처리)
        int[] recursionArr = oddCollectFunc(removeFirstArr);

        // result 배열 + recursionArr 배열 결합하여 oddArray를 생성
        int[] oddArray = new int[result.length + recursionArr.length];
        System.arraycopy(result, 0, oddArray, 0, result.length);
        System.arraycopy(recursionArr, 0, oddArray, result.length, recursionArr.length);

        return oddArray;
    }

    public static class OddCollector {
        private List<Integer> result = new ArrayList<>();

        private void helper(List<Integer> input) {
            int length = input.size();
            if (length == 0) {
                return;
            }

            Integer number = input.get(0);
            if (number % 2 != 0) {
                result.add(number);
            }

            input.remove(0);

            helper(input);
        }

        public int[] getResult(int[] arr) {
            helper(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return result.stream().mapToInt(value -> value).toArray();
        }
    }


}
