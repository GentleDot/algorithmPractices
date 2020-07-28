package problems.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static List<Integer> listSort(List<Integer> targetList) {
        int size = targetList.size();

        if (size <= 1) return targetList;
        int pivot = targetList.get(size / 2);

        List<Integer> lesserArr = new ArrayList<>();
        List<Integer> equalArr = new ArrayList<>();
        List<Integer> greaterArr = new ArrayList<>();

        for (int num : targetList) {
            if (num < pivot) lesserArr.add(num);
            else if (num > pivot) greaterArr.add(num);
            else equalArr.add(num);
        }

        return Stream.of(listSort(lesserArr), equalArr, listSort(greaterArr))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    static int activityNotifications4(int[] expenditure, int d) {
        boolean isEven = false;
        int medianIndex = d / 2;
        if (d % 2 == 0) {
            isEven = true;
        }

        int result = 0;
        int length = expenditure.length;
        List<Integer> expenditures = new ArrayList<>();
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
            if (expenditures.size() < 2) {
                expenditures.add(expenditure[i]);
            } else {
                expenditures = listSort2(expenditures, expenditure[i]);
            }
        }

        return result;
    }

    private static List<Integer> listSort2(List<Integer> targetList, int addNum) {
        int size = targetList.size();
        int middleIndex = size / 2;
        Integer middleNum = targetList.get(middleIndex);
        List<Integer> lowerSide = new ArrayList<>();
        if (middleIndex != 0) {
            lowerSide = targetList.subList(0, middleIndex);
        }
        List<Integer> higherSide = targetList.subList(middleIndex, size);

        if (addNum > middleNum) {
            higherSide.add(addNum);
            higherSide.sort(null);
        } else if (addNum < middleIndex) {
            lowerSide.add(addNum);
            lowerSide.sort(null);
        } else {
            lowerSide.add(addNum);
        }

        return Stream.of(lowerSide, higherSide)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    static int activityNotifications5(int[] expenditure, int d) {
        int length = expenditure.length;
        int maximumExpenditure = 200;
        boolean isEven = false;
        int medianIndex = d / 2;
        int result = 0;

        // 기준 day인 d가 홀수인지 짝수인지 구분
        if (d % 2 == 0) {
            isEven = true;
        }

        // 0 <= expenditure[i] <= 200
        // 계수 정렬(Counting sort)을 위한 배열 생성
        int[] expenditureCounter = new int[maximumExpenditure + 1];

        // expenditure loop
        for (int i = 0; i < length; i++) {
            // index가 d 값 이상인 경우에는 expenditureCounter에서 해당 medianIndex를 활용해 median 확인
            if (i >= d) {
                float median = getMedian(expenditureCounter, medianIndex, isEven);

                // median * 2 값 이상으로 지출한 경우는 result + 1
                if (expenditure[i] >= median * 2) {
                    ++result;
                }

                // 대상 d의 범위에서 제외되는 숫자는 count - 1
                expenditureCounter[expenditure[i - d]] -= 1;
            }
            // 등장하는 expenditure의 count는 +1
            expenditureCounter[expenditure[i]] += 1;
        }

        // result를 반환
        return result;
    }

    private static float getMedian(int[] counter, int medianIndex, boolean isEven) {
        int length = counter.length;
        int numberCount = 0;
        int beforeNum = 0;
        int i;
        float result;

        // counter를 loop 돌며 탐색
        for (i = 0; i < length; i++) {
            int item = counter[i];

            // count가 양수가 아니면 continue (등장하지 않은 숫자는 제외)
            if (item <= 0) {
                continue;
            }

            // 갯수를 더해가며 index를 파악
            numberCount += item;

            if (numberCount >= (medianIndex + 1)) {
                break;
            }
            // 이전에 등장한 수를 기록해둠
            beforeNum = i;
        }

        // medianIndex를 초과한 count를 확인
        int remainCount = numberCount - medianIndex;

        // median은 짝수냐 홀수냐에 따라 산출을 달리함
        if (isEven) {
            if (counter[i] > remainCount) {
                result = i; // (i + i) / 2 = 2i / 2 = i
            } else {
                result = (beforeNum + i) / 2f;
            }
        } else {
            result = i;
        }

        return result;
    }
}
