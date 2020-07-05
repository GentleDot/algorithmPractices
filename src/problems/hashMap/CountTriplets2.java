package problems.hashMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountTriplets2 {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long result = 0L;
        long size = arr.size();

        HashMap<Long, Long> foundDuoMap = new HashMap<>();
        HashMap<Long, Long> tripletsCountMap = new HashMap<>();


        // arr를 한 번만 탐색하면서 a, b를 기록하고 c를 판단해서 결과를 + 시키는 방식으로 변경
        // arr의 item인 targetItem이 존재하는 상태에서
        // targetItem * r 은 두 번째 item이 되어야 함. -> foundDuoMap 에 기록
        // targetItem이 foundDuoMap에 기록되어 있다면 triplets으로 생성할 수 있음
        for (int i = 0; i < size; i++) {
            Long targetItem = arr.get(i);

            result += tripletsCountMap.getOrDefault(targetItem, 0L);

            // tripletsCountMap의 item 증가는 상수 1L이 아니고 foundDuoMap에 있는 가능성이 + 증가하는 것
            if (foundDuoMap.containsKey(targetItem)) {
                long thirdItem = targetItem * r;
                tripletsCountMap.put(thirdItem, tripletsCountMap.getOrDefault(thirdItem, 0L) + foundDuoMap.get(targetItem));
            }

            // getOrDefault가 필요한 이유는
            // 1) 현재 key로 들어가 있는 갯수에 +1 update를 구현하기 위해
            // 2) get 할 때 key 확인을 위한 if - else 문을 축약하기 위해
            /*if (foundDuoMap.containsKey(targetItem * r)){
                foundDuoMap.put(targetItem * r, foundDuoMap.get(targetItem * r) + 1L);
            } else {
                foundDuoMap.put(targetItem * r, 1L);
            }*/
            foundDuoMap.put(targetItem * r, foundDuoMap.getOrDefault(targetItem * r, 0L) + 1L);

            System.out.println("result : " + result);
            System.out.println("tripletsCountMap : " + tripletsCountMap);
            System.out.println("foundDuoMap : " + foundDuoMap);
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/

        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arr.add(1L);
        }
        long r = 1;
        long ans = countTriplets(arr, r);
        System.out.println(ans);
    }
}
