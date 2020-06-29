package problems.array;

public class MergeArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        // arr1, arr2, resultArr 배열을 handling 할 수 있는 index 설정
        int arr1Counter = 0, arr2Counter = 0, resultArrCounter = 0;

        // 전달 받은 배열 길이 확인
        int lengthArr1 = arr1.length;
        int lengthArr2 = arr2.length;

        // 배열에 값이 없는 경우 상태라면 다른 배열을 그대로 return
        if (lengthArr2 < 1) {
            return arr1;
        } else if (lengthArr1 < 1) {
            return arr2;
        }

        // 정렬 시킬 결과를 담을 배열 생성
        int[] resultArr = new int[lengthArr1 + lengthArr2];

        // arr1의 item, itemInArr1과 arr2의 item itemInArr2를 비교하기 위해 loop 설정
        while (arr1Counter < lengthArr1 && arr2Counter < lengthArr2) {
            int itemInArr1 = arr1[arr1Counter];
            int itemInArr2 = arr2[arr2Counter];

            // itemInArr1, itemInArr2 중 최소값을 resultArr에 추가
            int min = Math.min(itemInArr1, itemInArr2);

            resultArr[resultArrCounter] = min;
            ++resultArrCounter;

            // 배열에서 탐색이 진행된 경우 index + 1
            if (min == itemInArr1) {
                arr1Counter++;
            } else {
                arr2Counter++;
            }
        }

        // 비교되지 않은 배열의 item이 존재하는 경우 resultArr에 추가
        if (arr1Counter == lengthArr1) {
            for (; arr2Counter < lengthArr2; arr2Counter++) {
                resultArr[resultArrCounter] = arr2[arr2Counter];
                ++resultArrCounter;
            }
        } else {
            for (; arr1Counter < lengthArr1; arr1Counter++) {
                resultArr[resultArrCounter] = arr1[arr1Counter];
                ++resultArrCounter;
            }
        }

        // 결과 배열을 반환
        return resultArr;
    }
}
