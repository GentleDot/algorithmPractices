package multiplePointers;

public class CountUniqueValues {
    public static void main(String[] args) {
        System.out.println(countUniqueNumbers(new int[]{1,1,1,1,1,2}));
        System.out.println(countUniqueNumbers(new int[]{1,2,3,4,4,4,7,7,12,12,13}));
        System.out.println(countUniqueNumbers(new int[]{}));
        System.out.println(countUniqueNumbers(new int[]{-2,-1,-1,0,1}));
    }

    public static int countUniqueNumbers(int[] arr) {
        // arr 확인
        // arr가 null 또는 빈 배열이면 0 출력
        if (arr == null) {
            return 0;
        }
        int length = arr.length;
        if (length == 0) {
            return length;
        }

        // arr를 index 0부터 시작해서 숫자 count
        int idx = 0;
        for (int j = 0; j < length ; j++) {
            if (arr[idx] != arr[j]){
                idx++;
                arr[idx] = arr[j];
            }
        }
        // count 값을 출력
        return idx + 1;
    }
}
