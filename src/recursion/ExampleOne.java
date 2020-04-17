package recursion;

public class ExampleOne {
    public static void main(String[] args) {
        countDownRecursive(5);
        countDownLoop(5);
    }

    public static void countDownRecursive(int num) {
        if (num <= 0) {
            System.out.println("완료!");
            return;
        }

        System.out.println(num);
        countDownRecursive(num - 1);
    }

    public static void countDownLoop(int num) {
        for (int i = num; i > 0; i--) {
            System.out.println(i);
        }

        System.out.println("완료!");
    }

}
