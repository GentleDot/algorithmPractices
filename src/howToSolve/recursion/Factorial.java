package howToSolve.recursion;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        // 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
        System.out.println(calculateFatorial(100));
    }

    private static BigInteger calculateFatorial(int num) {
        if (num <= 1) {
            return BigInteger.valueOf(1);
        }

        BigInteger baseNum = new BigInteger(String.valueOf(num));

        return baseNum.multiply(calculateFatorial(num - 1));
    }
}
