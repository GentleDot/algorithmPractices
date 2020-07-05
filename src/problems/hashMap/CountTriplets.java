package problems.hashMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountTriplets {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long result = 0L;
        long size = arr.size();

        ArrayList<long[]> duoList = new ArrayList<>();

        // triplet 이 될 수 있는 duo를 선발
        for (int i = 0; i < (size - 1); i++) {
            long firstItem = arr.get(i);

            for (int j = i + 1; j < size; j++) {
                long secondItem = arr.get(j);
                if (j >= (size - 1)) continue;
                if (secondItem / (float) firstItem == r) {
                    long[] tripletAble = {i, j};
                    //  System.out.println("tripletAble : " + Arrays.toString(tripletAble));
                    if (duoList.contains(tripletAble)) {
                        continue;
                    } else {
                        duoList.add(tripletAble);
                    }
                }
            }
        }

        // duo인 int[] 의 두 번째 item (int[1]) 의 다음 index부터 탐색해서
        // 해당 수가 triplet이 될 수 있다면 result + 1
        // 판단 기준은 thirdItem / secondItem 이 r이 되는 경우
        int listSize = duoList.size();
        for (int k = 0; k < listSize; k++) {
            long[] targetArr = duoList.get(k);
            long secondIdx = targetArr[1];
            for (int l = (int) secondIdx + 1; l < size; l++) {

                long secondItem = arr.get((int) targetArr[1]);
                long thirdItem = arr.get(l);

                if (thirdItem / (float) secondItem == r) {
                    result += 1L;
                }
            }
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
    }
}
