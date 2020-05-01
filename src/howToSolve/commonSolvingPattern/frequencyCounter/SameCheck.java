package howToSolve.commonSolvingPattern.frequencyCounter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SameCheck {
    public static void main(String[] args) {
//        System.out.println(same(new int[]{1, 2, 3, 2}, new int[]{9, 1, 4, 4}));
        System.out.println(sameRefactored(new int[]{1, 2, 3, 2}, new int[]{9, 1, 4, 4}));

    }

    public static boolean same(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        if (arr1Length != arr2Length) {
            return false;
        }

        List<Integer> arr2List = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toList());


        for (int i = 0; i < arr1Length; i++) {
            int arr1Item = arr1[i];
            Optional<Integer> matchedArr2Item = arr2List.stream().filter(value -> value == Math.pow(arr1Item, 2)).findFirst();

            if (matchedArr2Item.isEmpty()) {
                return false;
            }
            System.out.println(arr2List);
            arr2List.remove(matchedArr2Item.get());
        }

        return true;
    }

    public static boolean sameRefactored(int[] arr1, int[] arr2) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        if (arr1Length != arr2Length) {
            return false;
        }

        /*Map<Integer, Long> arr1Map = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.groupingBy(item -> item,
                        Collectors.counting()));*/

        Map<Integer, Integer> arr1Map = Arrays.stream(arr1)
                .boxed()
                .collect(Collectors.groupingBy(item -> item,
                        Collectors.reducing(0, value -> 1, Integer::sum)));

        Map<Integer, Integer> arr2Map = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toMap(item -> item, value -> 1, Integer::sum));

        for (int key : arr1Map.keySet()) {
            if (!arr2Map.containsKey((int) Math.pow(key, 2))) {
                return false;
            } else if (!arr2Map.get((int) Math.pow(key, 2)).equals(arr1Map.get(key))) {
                return false;
            }
        }

        System.out.println(arr1Map);
        System.out.println(arr2Map);
        return true;
    }
}