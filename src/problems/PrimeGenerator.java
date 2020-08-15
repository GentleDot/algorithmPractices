package problems;

/**
 * 출처 : clean code: 애자일 소프트웨어 장인 정신(5쇄) [로버트 C. 마틴, 옮긴이: 박재호, 이해영](인사이트, 2018) p92 - p94
 * 이 클래스는 사용자가 지정한 최대 값까지 소수를 구한다
 * 알고리즘은 에라스토테네스의 체다.
 * 2에서 시작하는 정수 배열을 대상으로 작업한다.
 * 처음으로 남아 있는 정수를 찾아 배수를 모두 제거한다.
 * 배열에 더 이상 배수가 없을 때까지 반복한다.
 */

public class PrimeGenerator {
    private static final int VALID_VALUE_MIN = 2;

    private static boolean[] crossedOut;
    private static int[] result;
    private static int crossedOutLength;

    public static int[] generatePrimes(int maxValue) {
        if (maxValue < VALID_VALUE_MIN)
            return new int[0];
        else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        crossedOutLength = crossedOut.length;

        for (int i = VALID_VALUE_MIN; i < crossedOutLength; i++)
            crossedOut[i] = false;
    }

    private static void crossOutMultiples() {
        int limit = determineIterationLimit();
        for (int i = VALID_VALUE_MIN; i <= limit; i++) {
            if (notCrossed(i))
                crossOutMultiplesOf(i);
        }
    }

    private static int determineIterationLimit() {
        // 배열에 있는 모든 배수는 배열 크기의 제곱근보다 작은 소수의 인수다.
        // 따라서 이 제곱근보다 더 큰 숫자의 배수는 제거할 필요가 없다.
        double iterationLimit = Math.sqrt(crossedOutLength);
        return (int) iterationLimit;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = VALID_VALUE_MIN * i; multiple < crossedOutLength; multiple += i) {
            crossedOut[multiple] = true;
        }
    }

    private static boolean notCrossed(int i) {
        return !crossedOut[i];
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        for (int j = 0, i = VALID_VALUE_MIN; i < crossedOutLength; i++) {
            if (notCrossed(i))
                result[j++] = i;
        }
    }

    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = VALID_VALUE_MIN; i < crossedOutLength; i++)
            if (notCrossed(i))
                count++;

        return count;
    }
}