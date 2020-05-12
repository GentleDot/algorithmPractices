package howToSolve.sort.nonComparisonSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static howToSolve.Main.log;

public class RadixSort {
    public static void main(String[] args) {
//        System.out.println(getDigit(7323, 2));
//        System.out.println(digitCount(322));
//        System.out.println(mostDigit(new int[]{12, 34, 56, 789}));
        System.out.println(Arrays.toString(sort(new int[]{23, 345, 5467, 12, 2345, 9852})));
    }

    public static int getDigit(int number, int index) {
        /*log.debug("abs value : {}", Math.abs(number));
        log.debug("pow value : {}", Math.pow(10, index));
        log.debug("abs / pow value : {}", Math.abs(number) / Math.pow(10, index));
        log.debug("(abs / pow) % 10 value : {}", (Math.abs(number) / Math.pow(10, index)) % 10);
        log.debug("(abs / pow) % 10 value cast int : {}", (int) (Math.abs(number) / Math.pow(10, index)) % 10);*/
        return (int) ((Math.abs(number) / Math.pow(10, index)) % 10);
    }

    public static int digitCount(int number) {
        if (number == 0) {
            return 1;
        }
        /*log.debug("abs value : {}", Math.abs(number));
        log.debug("log10 value : {}", Math.log10(Math.abs(number)));
        log.debug("log10 value cast int : {}", (int) Math.log10(Math.abs(number)));*/
        return (int) (Math.log10(Math.abs(number))) + 1;
    }

    public static int mostDigit(int[] numbers) {
        int maxDigit = 0;
        for (int item : numbers) {
            maxDigit = Math.max(maxDigit, digitCount(item));
        }

        return maxDigit;
    }

    public static int[] sort(int[] array) {
        // 배열 자릿수 확인
        int length = array.length;

        if (length <= 1) {
            return array;
        }

        // 가장 큰 자릿수 확인
        int maximumDigit = mostDigit(array);

        // 0부터 큰 자릿수까지 loop 진행
            // 요소를 자유롭게 입력할 수 있도록 list로 작업
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        for (int i = 0; i < maximumDigit; i++) {
            // 각 자릿수마다 정렬된 요소를 넣을 bucket list 생성
            ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                bucket.add(new ArrayList<>());
            }

            for (int j = 0; j < length; j++) {
                Integer targetNumber = list.get(j);
                int digit = getDigit(targetNumber, i);
                log.debug("대상 값 : {}, 현재 자릿수 : {}, 자릿수 확인 : {}", targetNumber, i, digit);
                bucket.get(digit).add(targetNumber);
            }

            log.debug("bucket 확인 : {}", bucket);

            // list를 비운 뒤 bucket의 값으로 채우기
            list.clear();
            bucket.forEach(list::addAll);

            log.debug("list 확인 : {}", list);
        }

        // 정렬된 list를 int 배열로 반환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
