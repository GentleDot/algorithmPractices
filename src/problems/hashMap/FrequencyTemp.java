package problems.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyTemp {
    public static void main(String[] args) {
//        Stream.of("apple", "orange", "banana", "apple")
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .values().stream().anyMatch(aLong -> aLong > 1);
        System.out.println();
    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        int size = queries.size();

        ArrayList<Integer> dataArray = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        queries.forEach(integers -> {
            Integer query = integers.get(0);
            Integer data = integers.get(1);

            if (query.equals(1)) {
                dataArray.add(data);
            } else if (query.equals(2)) {
                dataArray.remove(data);
            } else if (query.equals(3)) {
                if (data.equals(1)) {
                    if (dataArray.isEmpty()) {
                        result.add(0);
                    } else {
                        result.add(1);
                    }
                } else {
                    boolean checkFrequency = dataArray.stream()
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                            .values().stream().anyMatch(frequency -> frequency >= data);
                    result.add(checkFrequency ? 1 : 0);
                }
            }
        });

        return result;
    }

    static List<Integer> freqQuery2(List<List<Integer>> queries) {
        int size = queries.size();

        ArrayList<Integer> dataArray = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Long> itemCountMap = new HashMap<>();

        for (List<Integer> integerList : queries) {
            Integer query = integerList.get(0);
            Integer data = integerList.get(1);

            if (query.equals(1)) {
                dataArray.add(data);
                itemCountMap.put(data, itemCountMap.getOrDefault(data, 0L) + 1);
            } else if (query.equals(2)) {
                dataArray.remove(data);
                if (itemCountMap.containsKey(data)) {
                    if (itemCountMap.get(data) != 0) {
                        itemCountMap.put(data, itemCountMap.get(data) - 1);
                    }
                }
            } else if (query.equals(3)) {
                boolean checkFrequency = itemCountMap.containsValue(data.longValue());
                result.add(checkFrequency ? 1 : 0);
            }
        }

        return result;
    }

    // test case 11번이... timeout  T_T
    static List<Integer> freqQuery3(List<List<Integer>> queries) {

        // 결과를 기록할 list 생성
        ArrayList<Integer> result = new ArrayList<>();

        // array 내 요소 빈도를 저장할 map 생성
        HashMap<Integer, Integer> itemCountMap = new HashMap<>();

        // queries를 탐색 (loop)
        for (List<Integer> integerList : queries) {
            Integer query = integerList.get(0);
            Integer data = integerList.get(1);

            // 1은 해당 숫자 array에 추가
            if (query.equals(1)) {
                itemCountMap.put(data, itemCountMap.getOrDefault(data, 0) + 1);
                // 2는 해당 숫자 array에서 제거
            } else if (query.equals(2)) {
                if (itemCountMap.containsKey(data)) {
                    if (itemCountMap.get(data) > 0) {
                        itemCountMap.put(data, itemCountMap.get(data) - 1);
                    }
                }
                // 3은 array에서 해당 숫자만큼의 빈도가 있는 요소 확인
            } else if (query.equals(3)) {
                boolean checkFrequency = itemCountMap.containsValue(data);
                result.add(checkFrequency ? 1 : 0);
            }
        }

        return result;
    }

    static List<Integer> freqQuery4(List<List<Integer>> queries) {

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> itemCountMap = new HashMap<>();

        for (List<Integer> integerList : queries) {
            Integer query = integerList.get(0);
            Integer data = integerList.get(1);

            if (query.equals(1)) {
                itemCountMap.put(data, itemCountMap.getOrDefault(data, 0) + 1);
            } else if (query.equals(2)) {
                if (itemCountMap.containsKey(data)) {
                    if (itemCountMap.get(data) > 0) {
                        itemCountMap.put(data, itemCountMap.get(data) - 1);
                    }
                }
            } else if (query.equals(3)) {
                Object[] objects = itemCountMap.values().toArray();
                Arrays.sort(objects);
                System.out.println(Arrays.toString(objects));
                result.add(checkFrequency(objects, data));
            }
        }

        return result;
    }

    private static Integer checkFrequency(Object[] values, int target) {
        int size = values.length;
        if (size == 0) {
            return 0;
        }

        int startPointer = 0;
        int endPointer = size - 1;


        while (startPointer <= endPointer) {
            int middle = (startPointer + endPointer) / 2;
            int middleValue = (int) values[middle];

            if (target == (middleValue)) {
                return 1;
            } else if (target > middleValue) {
                startPointer = middle + 1;
            } else if (target < middleValue) {
                endPointer = middle - 1;
            }
        }

        return 0;
    }

    static List<Integer> freqQuery5(List<List<Integer>> queries) {
        // 결과를 처리할 list 생성
        ArrayList<Integer> result = new ArrayList<>();
        // 카운트를 셀 map 생성
        HashMap<Integer, Integer> itemCountMap = new HashMap<>();
        // 카운트 결과를 key로 하는 map 생성
        HashMap<Integer, List<Integer>> countResultMap = new HashMap<>();

        // query를 탐색하면서 쿼리를 처리
        for (List<Integer> integerList : queries) {
            Integer query = integerList.get(0);
            Integer data = integerList.get(1);

            // 1번은 array에 data 추가
            // 추가 시 빈도를 key로 해서 들어간 data를 value로 해서 countResultMap에 기록
            if (query.equals(1)) {
                Integer increaseCount = itemCountMap.getOrDefault(data, 0) + 1;
                itemCountMap.put(data, increaseCount);
                if (countResultMap.containsKey(increaseCount)) {
                    countResultMap.get(increaseCount).add(data);
                } else {
                    countResultMap.put(increaseCount, new ArrayList<>());
                    countResultMap.get(increaseCount).add(data);
                }

                // 2번은 array에 data 제거
                // 제거 시에도 추가와 동일하게 빈도를 countResultMap에 기록
            } else if (query.equals(2)) {
                if (itemCountMap.containsKey(data)) {
                    if (itemCountMap.get(data) > 0) {
                        int decreaseCount = itemCountMap.get(data) - 1;
                        itemCountMap.put(data, decreaseCount);
                        if (countResultMap.containsKey(decreaseCount)) {
                            countResultMap.get(decreaseCount).add(data);
                        }
                    }
                }

                // 3번은 data 만큼의 빈도를 가진 item이 존재하는지 여부 확인
            } else if (query.equals(3)) {
                // itemCountMap.containsValue(data) 는 item을 다 탐색해서 결과를 보여주므로 아마 O(n)
                // 결론은 O(n)보다 복잡도가 작은 로직을 구현해야 한다는 것... 와......
                // boolean checkFrequency = itemCountMap.containsValue(data);

                // 빈도수를 key로 해서 조회를 하면 O(1)이니까...
                // 빈도수를 기록했던 item의 실제 빈도를 확인하면 O(1)
                // 빈도수 기록을 탐색하는데는 data와 동일한 빈도수가 존재할 때 break가 걸리므로
                //  - 복잡도는 O(n) 이하가 될 것임 (최악에는 O(n))
                if (countResultMap.containsKey(data)) {
                    List<Integer> items = countResultMap.get(data);
                    int itemsSize = items.size();
                    int countChk = 0;
                    for (int i = 0; i < itemsSize; i++) {
                        if (itemCountMap.get(items.get(i)) == data) {
                            countChk = 1;
                            break;
                        }
                    }
                    result.add(countChk);
                } else {
                    result.add(0);
                }
            }
        }

        return result;
    }

}
