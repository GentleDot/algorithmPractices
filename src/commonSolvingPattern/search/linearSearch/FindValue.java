package commonSolvingPattern.search.linearSearch;

public class FindValue {
    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{34, 56, 1, 2}, 1));
    }

    public static Integer linearSearch(int[] arr, int val){
        // 배열 길이 확인
        int length = arr.length;

        // 배열의 길이만큼 loop
            // 만약 주어진 값이 배열 요소의 값과 동일하다면 index를 반환
        for (int i = 0; i < length ; i++) {
            if (arr[i] == val){
                return i;
            }
        }

        // loop에서 값을 찾을 수 없다면 null 반환
        return null;
    }
}
