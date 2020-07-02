package problems.anagrams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SherlockAndAnagrams {
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        // s = "abba"라면
        int length = s.length();
        if (length <= 0) {
            return 0;
        }

        AtomicInteger result = new AtomicInteger();

        HashMap<Character, Boolean> checkStrMap = new HashMap<>();

        // string을 char array로 재정의
        // chars = {a, b, b, a}
        char[] chars = s.toCharArray();
        ArrayList<String> checkStrs = new ArrayList<>();
        // 단어 하나마다 index를 확인하기 위해 loop를 돈다
        for (int i = 0; i < length; i++) {
            char targetChar = chars[i];
            long count = s.chars().filter(c -> c == targetChar).count();

            if (checkStrMap.get(targetChar) != null && checkStrMap.get(targetChar)){
                continue;
            }

            if (count > 1) {
                checkStrMap.putIfAbsent(targetChar, true);
                int start = s.indexOf(targetChar);
                int end = start;
                for (int j = 1; j < count; j++) {
                    end = s.indexOf(targetChar, end + 1);
                    char[] targetArea = Arrays.copyOfRange(chars, start, end + 1);

                    int targetLength = targetArea.length;

                    StringBuilder checkStrBuilder = new StringBuilder();
                    for (int k = 0; k < targetLength - 1; k++) {
                        checkStrBuilder.append(targetArea[k]);
                        checkStrs.add(checkStrBuilder.toString());
                    }


                    for (int k = (targetArea.length - 1); k > 0; k--) {
                        StringBuilder compareStrBuilder = new StringBuilder();
                         for (int l = k; l > 0; l--) {
                            compareStrBuilder.append(targetArea[l]);
                            checkStrs.stream().forEach(str -> {
                                char[] compareStr1 = str.toCharArray();
                                char[] compareStr2 = compareStrBuilder.toString().toCharArray();

                                Arrays.sort(compareStr1);
                                Arrays.sort(compareStr2);

                                 if (Arrays.equals(compareStr1, compareStr2)){
                                    result.addAndGet(1);
                                }
                            });
                        }
                    }
                    checkStrs.clear();
                }

            }
        }

        /*ArrayList<String> checkStrs = new ArrayList<>();
        charMap.values().stream().forEach(ints -> {
            int start = ints[0];
            int end = ints[1];
            char[] targetArea = Arrays.copyOfRange(chars, start, end + 1);
            int targetLength = targetArea.length;


            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < targetLength - 1; i++) {
                builder.append(targetArea[i]);
                checkStrs.add(builder.toString());
            }
        });

        ArrayList<String> checkStrs = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            char targetChar = chars[i];
            long count = s.chars().filter(c -> c == targetChar).count();


            if (checkStrs.contains(String.valueOf(targetChar))) {
                continue;
            }
            if (count > 1) {
                int start = s.indexOf(targetChar);
                int end = s.lastIndexOf(targetChar);
                char[] targetArea = Arrays.copyOfRange(chars, start, end + 1);

                int targetLength = targetArea.length;

                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < targetLength - 1; j++) {
                    builder.append(targetArea[j]);
                    checkStrs.add(builder.toString());
                }
            }
        }*/


        return result.get();
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
        int result = sherlockAndAnagrams("ifailuhkqq");
        System.out.println(result);
    }
}


