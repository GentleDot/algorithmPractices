package problems.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ActivityNotifications {
    public static void main(String[] args) {
        /*LinkedList<Integer> expenditures = new LinkedList<>();
        expenditures.sort(Integer::compareTo);
        expenditures.removeFirst();
        System.out.println();
        Arrays.copyof
        int[] ints = Arrays.copyOfRange(new int[]{1, 2}, 1, 2);
        Arrays.sort(ints);
        HashSet<Object> objects = new HashSet<>();*/

        int[] ints = {2, 6, 4, 3};
        int[] anotherInts = Arrays.copyOf(ints, ints.length);

        Arrays.sort(anotherInts);

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(anotherInts));

    }

    static int activityNotifications(int[] expenditure, int d) {
        boolean isEven = false;
        int medianIndex = d / 2;
        if (d % 2 == 0) {
            isEven = true;
        }

        int result = 0;
        int length = expenditure.length;
        ArrayList<Integer> expenditures = new ArrayList<>();
        // expenditure loop
        for (int i = 0; i < length; i++) {
            // d 초과시 현재 소비값과 d 길이의 배열간의 median 산출
            if (i >= d) {
                expenditures.sort(Comparator.naturalOrder());
                float median = 0f;
                if (isEven) {
                    median = (expenditures.get(medianIndex) + expenditures.get(medianIndex - 1)) / 2f;
                } else {
                    median = expenditures.get(medianIndex);
                }

                // median * 2가 현재 소비값보다 크거나 같다면 alert + 1
                if (expenditure[i] >= median * 2) {
                    result++;
                }

                expenditures.remove(0);
            }

            expenditures.add(expenditure[i]);
        }

        return result;
    }

    // Complete the activityNotifications function below.
    static int activityNotifications2(int[] expenditure, int d) {
        int result = 0;
        int length = expenditure.length;
        // expenditure loop
        for (int i = 0; i < length; i++) {
            if (i >= d) {
                int[] expenditures = Arrays.copyOfRange(expenditure, i - d, i);
                Arrays.sort(expenditures);
                float median = 0f;
                if (d % 2 == 0) {
                    median = (expenditures[(d / 2)] + expenditures[((d / 2) - 1)]) / 2f;
                } else {
                    median = expenditures[(d / 2)];
                }

                if (expenditure[i] >= median * 2) {
                    result++;
                }
            }
        }
        // d 초과시 현재 소비값과 d길이의 배열간의 median 산출
        // median * 2가 현재 소비값보다 크거나 같다면 alert + 1
        return result;
    }

    static int activityNotifications3(int[] expenditure, int d) {
        int result = 0;
        int length = expenditure.length;
        ArrayList<Integer> expenditures = new ArrayList<>();
        // expenditure loop
        for (int i = 0; i < length; i++) {
            // d 초과시 현재 소비값과 d길이의 배열간의 median 산출
            if (i >= d) {
                List<Integer> sortedExpenditures = listSort(expenditures);
                float median = 0f;
                if (d % 2 == 0) {
                    median = (sortedExpenditures.get(d / 2) + sortedExpenditures.get((d / 2) - 1)) / 2f;
                } else {
                    median = sortedExpenditures.get(d / 2);
                }
                System.out.println("median : " + median);

                // median * 2가 현재 소비값보다 크거나 같다면 alert + 1
                if (expenditure[i] >= median * 2) {
                    result++;
                }

                expenditures.remove(0);
            }

            expenditures.add(expenditure[i]);
        }

        return result;
    }

    private static List<Integer> listSort(List<Integer> target) {
        int size = target.size();

        for (int i = 0; i < size; i++) {
            target.get(i);
        }
        return null;
    }
}
