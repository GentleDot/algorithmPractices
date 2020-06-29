package problems.array;

public class ReverseString {
    public static String reverse(String targetStr) {
        // 받은 string 길이 length 확인
        int length = targetStr.length();
        // string 길이가 0이하 라면 null 반환
        if (length <= 0) {
            return null;
        }
        // string을 char 배열로 변환
        char[] chars = targetStr.toCharArray();

        // string의 끝에서부터 처음까지 loop
        // StringBuilder로 뒤집힌 문자열 생성
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = (length - 1); i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }

        // 결과 리턴
        return stringBuilder.toString();
    }

    public static String betterReverse(String targetStr) {
        StringBuilder stringBuilder = new StringBuilder(targetStr);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
