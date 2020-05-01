package search.binarySearch;

public class SearchValue {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2,4,5,9,11,14,15,19,21,25,28,30,50,52,60,63}, 28));
    }

    public static Integer binarySearch(int[] arr, int val) {
        // 배열 길이가 0이면 null 반환
        int length = arr.length;
        if (length == 0) {
            return null;
        }

        // 배열 시작지점, 중간지점, 종료지점 포인터 설정
        int startPointer = 0;
        int endPointer = length - 1;
        int middle = (startPointer + endPointer) / 2;

        // 시작지점 포인터가 종료지점 포인터 앞에 오는 동안 loop
        // 중간지점의 값을 확인
        // 중간 값이 설정 값과 같다면 index를 반환
        // 중간 값이 설정 값보다 크다면 종료지점은 중간지점 - 1
        // 중간 값이 설정 값보다 작다면 시작지점은 중간지점 + 1
        // 중간지점 재설정
        while (startPointer <= endPointer) {
            int targetValue = arr[middle];
            if (targetValue == val) {
                return middle;
            } else if (targetValue > val) {
                endPointer = middle - 1;
            } else if (targetValue < val) {
                startPointer = middle + 1;
            }

            middle = (startPointer + endPointer) / 2;
        }

        // loop에서 답을 찾을 수 없다면 null을 반환
        return null;
    }
}
