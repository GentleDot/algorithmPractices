public class TempSum {
    public static void main(String[] args) {
        /*int i = 999;
        boolean contains = String.valueOf(i).contains("3");
        System.out.println(i % 3);
        System.out.println(contains);
        System.out.println(i % 10);*/
        int[] ints = new int[1001];
        for (int i = 1; i <= 1000; i++) {
            ints[i] = i;
        }
        System.out.println(sumArrayNum(ints));
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
