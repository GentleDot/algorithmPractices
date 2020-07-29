public class TempProcessing {
    public static void main(String[] args) {
        /*int[] ints = new int[1001];
        for (int i = 1; i <= 1000; i++) {
            ints[i] = i;
        }
        System.out.println(sumArrayNum(ints));*/

        System.out.println(compareStrings("abcde", "abc"));
    }

    private static int compareStrings(String baseStr, String otherStr) {
        // 같은 문자열은 0
        // 다른 문자열은 ascii 오름차순
        // 길이가 다른 문자열은 내림차순 비교

        int baseLength = baseStr.length();
        int otherLength = otherStr.length();

        int limit = Math.min(baseLength, otherLength);
        for (int i = 0; i < limit; i++) {
            int baseChar = baseStr.charAt(i);
            int otherChar = otherStr.charAt(i);
            if (baseChar != otherChar) {
                return baseChar - otherChar;
            }
        }
        return otherLength - baseLength;
    }

    private static long sumArrayNum(int[] numbers) {
        int length = numbers.length;
        long result = 0;

        for (int num : numbers) {
            boolean isMultiplesOfThree = num % 3 == 0;
            boolean isContainsThree = String.valueOf(num).contains("3");

            // 조건 1 : 3의 배수 또는 숫자 속 3이 있는 숫자는 합한다
            if (isMultiplesOfThree || isContainsThree) {
                boolean isMultipleOfTen = num % 10 == 0;

                // 조건 2 : 조건 1의 숫자 중 10의 배수에 해당하는 숫자는 제외
                if (!isMultipleOfTen) {
                    result += num;
                }
            }
        }
        return result;
    }
}
