package dataStructure.hashTable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static howToSolve.Main.log;

public class HashTable {
    private final int primeNumber = 31;

    private List<List<String[]>> keyMap;
    private int keyMapSize;

    public HashTable() {
        this(53);
    }

    public HashTable(int size) {
        this.keyMapSize = size;
        this.keyMap = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.keyMap.add(new ArrayList<>());
        }
    }

    public List<List<String[]>> getKeyMap() {
        return keyMap;
    }

    public int getKeyMapSize() {
        return keyMapSize;
    }

    public Integer hash(String key) {
        int total = 0;
        int length = key.length();
        for (int i = 0; i < Math.min(length, 100); i++) {
            char charValue = key.charAt(i);
            int value = charValue - 96;

//            log.info("value : {} // total * primeNumber + value = {}", value, ((total * primeNumber) + value));
            total = ((total * primeNumber) + value) % keyMapSize;
//            log.info("total = {}", total);
        }

        return total;
    }

    public void set(String key, String value) {
        int index = hash(key);
        log.info("key hashing : {}", index);

        if (this.keyMap.get(index) == null) {
            this.keyMap.set(index, new ArrayList<>());
        }

        this.keyMap.get(index).add(new String[]{key, value});
    }

    public String[] get(String key) {
        int index = hash(key);
        log.info("key hashing : {}", index);
        List<String[]> strings = this.keyMap.get(index);
        if (!strings.isEmpty()) {
            return strings.stream().filter(strList -> strList[0].equals(key)).findFirst().orElse(null);
        }

        return null;
    }

    public List<String> keys() {
        ArrayList<String> result = new ArrayList<>();
        this.keyMap.stream().forEach(pairs -> {
            pairs.forEach(strList -> result.add(strList[0]));
        });

        return result;
    }

    public List<String> values() {
        ArrayList<String> result = new ArrayList<>();
        this.keyMap.stream().forEach(pairs -> {
            pairs.forEach(strList -> result.add(strList[1]));
        });

        return result;
    }

    @SuppressWarnings("unchecked")
    public int findCapacity() throws Exception {

        Field field = this.keyMap.getClass().getDeclaredField("elementData");

        field.setAccessible(true);

        return ((Object[]) field.get(this.keyMap)).length;

    }
}
