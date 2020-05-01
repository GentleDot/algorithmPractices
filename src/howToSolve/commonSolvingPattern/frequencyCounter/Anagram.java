package howToSolve.commonSolvingPattern.frequencyCounter;

import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(checkVaildAnagram("", "")); // true
        System.out.println(checkVaildAnagram("aaz", "zza")); // false
        System.out.println(checkVaildAnagram("anagram", "nagaram")); // true
        System.out.println(checkVaildAnagram("rat", "car")); // false
        System.out.println(checkVaildAnagram("awesome", "awesom")); // false
        System.out.println(checkVaildAnagram("qwerty", "qeywrt")); // true
        System.out.println(checkVaildAnagram("texttwisttime", "timetwisttext")); // true
        System.out.println(checkVaildAnagram("iceman", "cinema")); // true

    }

    public static boolean checkVaildAnagram(String target, String madeOne) {
        // target 글자 수와 madeOne 글자 수가 같지 않으면 false
        int targetLength = target.length();
        int madeOneLength = madeOne.length();

        if (targetLength != madeOneLength) {
            return false;
        }

        // target, madeOne을 map으로 변환 (targetMap, madeOneMap)
        Map<Character, Long> targetMap = target.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(character -> character,
                        Collectors.counting()));

        /*Map<Character, Long> madeOneMap = madeOne.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(character -> character,
                        Collectors.counting()));*/

        // 글자 확인
        // targetMap의 key가 madeOneMap의 key에 없으면 false
        // targetMap의 key로 가져온 개수가 madeOneMap의 key로 가져온 개수와 같지 않다면 false
        for (char key : targetMap.keySet()) {
            if (!madeOne.contains(String.valueOf(key))) {
                return false;
            } else if (targetMap.get(key) <= 0) {
                return false;
            }
            targetMap.replace(key, targetMap.get(key) - madeOne.chars().filter(value -> value == key).count());
        }

        // 특이 사항이 없다면 true 반환
        System.out.println(targetMap);
        return targetMap.values().stream().noneMatch(value -> value > 0);
    }
}
