package commonSolvingPattern.search.naiveStringSearch;

public class SearchString {
    public static void main(String[] args) {
        System.out.println(naiveSearch("lorie loled", "lo"));
    }

    public static int naiveSearch(String longStr, String shortStr) {
        int result = 0;
        // 문자열 길이 확인 (대상 문자열 longStr, 찾을 문자열 shortStr)
        int longLength = longStr.length();
        int shortLength = shortStr.length();

        // longStr loop 생성
        // shortStr loop 생성
            // shortStr과 일치하지 않는 경우에는 shortStr loop 빠져나옴
            // shortStr과 모두 일치하면 result + 1
        for (int i = 0; i < longLength; i++) {
            for (int j = 0; j < shortLength; j++) {
                if (shortStr.charAt(j) != longStr.charAt(i + j)){
                    System.out.println("break!");
                    break;
                }
                if (j == shortLength - 1){
                    System.out.println("found one");
                    result++;
                }
            }
        }
        return result;
    }
}
