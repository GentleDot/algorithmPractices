package dataStructure.hashTable;

import static howToSolve.Main.log;

public class Hash {

    public Integer hash(String key, int arrayLen) {
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
}
