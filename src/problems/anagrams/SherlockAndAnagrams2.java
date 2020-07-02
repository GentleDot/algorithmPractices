package problems.anagrams;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/*
* HackerRank - Sherlock And Anagrams
* https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
* */
public class SherlockAndAnagrams2 {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        // 반환용 객체 result
        int result = 0;

        // 들어오는 String 길이 확인
        int length = s.length();

        // s의 길이가 0이면 0 반환
        if (length <= 0) {
            return 0;
        }

        // s를 charArray인 sChars로 변환
        char[] sChars = s.toCharArray();

        // 문자 탐색을 위한 for문 구성
        for (int l = 0; l < length - 1; l++) {
            for (int i = 0; i < length - 1; i++) {
                // substring이 동작하지 않는 범위는 skip
                if (l >= (i + 1)) {
                    continue;
                }
                /*
                    0123
                    kkkk

                    0부터 대상 문자열 생성 : (0)k, (0, 1)kk, (0, 2)kkk
                    +1 부터 대상 문자열 생성 : (1)k, (1, 2) kk
                    +1 부터 대상 문자열 생성 : (2)k
                    -> 결국 length - 1까지 탐색하는 loop + 자리를 옮기는 loop 필요
                */
                // 비교할 문자열을 substring으로 추출 (targetStr)
                String targetStr = s.substring(l, i + 1);
                for (int j = 1; j < length; j++) {
                    for (int k = j; k < length; k++) {
                        // 비교할 문자열 길이가 다른 경우에는 skip
                        if ((k + 1) - (l + j) != targetStr.length()) {
                            continue;
                        }
                        /*
                            0\123  ->  01\23 -> 012\3
                            k\kkk  ->  kk\kk -> kkk\k

                            0 + 1부터 비교 문자열 생성 : (1)k, (1, 2)kk, (1, 3)kkk
                            +1 부터 비교 문자열 생성 : (2)k, (2, 3) kk
                            +1 부터 비교 문자열 생성 : (3)k
                            -> 결국 l의 자리를 옮기는 loop + l부터 length까지 탐색하는 loop 필요
                        */
                        // 비교할 문자를 sChars 배열에서 추출
                        char[] compareChars1 = Arrays.copyOfRange(sChars, l + j, k + 1);
                        // targetStr을 배열로 변환
                        char[] compareChars2 = targetStr.toCharArray();

                        // 배열을 정렬
                        Arrays.sort(compareChars1);
                        Arrays.sort(compareChars2);

                        // 정렬된 배열들이 서로 동일한 값을 가지고 있으면 anagram으로 조합 가능한 상태이므로 result + 1
                        if (Arrays.equals(compareChars1, compareChars2)) {
                            result += 1;
                        }
                    }
                }
            }
        }

        // 카운트한 결과를 반환
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        /*int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println("result : " + result);
        }

        scanner.close();*/
        int result = sherlockAndAnagrams("mqmtjwxaaaxklheghvqcyhaaegtlyntxmoluqlzvuzgkwhkkfpwarkckansgabfclzgnumdrojexnrdunivxqjzfbzsodycnsnmw");
        System.out.println(result);
    }
}


