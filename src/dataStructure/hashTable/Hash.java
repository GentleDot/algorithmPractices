package dataStructure.hashTable;

import static howToSolve.Main.log;

public class Hash {
    private final int primeNumber = 31;

    public Integer oldHash(String key, int arrayLen) {
        int total = 0;
        for (char c : key.toCharArray()) {
            log.info("char : {}, charCode : {}", c, (int) c);
            var value = c - 96; // "a" = 97
            int totalValue = total + value;
            total = totalValue % arrayLen;
            log.info("value : {} // total + value = {}  // total = {}", value, totalValue, total);
        }
        return total;
    }

    public Integer hash(String key, int arrayLen) {
        int total = 0;
        int length = key.length();
        for (int i = 0; i < Math.min(length, 100); i++) {
            char charValue = key.charAt(i);
            int value = charValue - 96;

            log.info("value : {} // total * primeNumber + value = {}", value, ((total * primeNumber) + value));
            total = ((total * primeNumber) + value) % arrayLen;
            log.info("total = {}", total);
        }

        return total;
    }
}
