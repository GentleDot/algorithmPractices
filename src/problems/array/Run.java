package problems.array;

import java.util.Arrays;

import static problems.array.ReverseString.*;

public class Run {
    public static void main(String[] args) {
        System.out.println(reverse("안녕하세요."));
        System.out.println(reverse("hello, world."));
        System.out.println(betterReverse("hello, world."));
        System.out.println(Arrays.toString(MergeArrays.mergeSortedArrays(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30})));
    }
}
