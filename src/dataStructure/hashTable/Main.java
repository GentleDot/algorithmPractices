package dataStructure.hashTable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
//        Hash hash = new Hash();
        /*System.out.println(hash.oldHash("pink", 10));
        System.out.println(hash.oldHash("orangered", 10));
        System.out.println(hash.oldHash("cyan", 10));*/
        /*System.out.println(hash.hash("hello", 13));
        System.out.println(hash.hash("goodbye", 13));
        System.out.println(hash.hash("cyan", 13));*/

        HashTable table = new HashTable();
        /*System.out.println(table.getKeyMap().size());
        System.out.println(table.getKeyMap().toArray().length);*/
//        System.out.println(table.findCapacity());
        table.set("hello world", "goodbye!!");
        System.out.println(Arrays.toString(table.getKeyMap().get(40).get(0)));
        System.out.println(Arrays.toString(table.get("hello world")));

        HashTable colorTable = new HashTable(17);
        colorTable.set("maroon", "#800000");
        colorTable.set("yellow", "#FFFF00");
        colorTable.set("lightcoral", "#F08080");
        System.out.println("======");
        System.out.println(Arrays.toString(colorTable.get("maroon")));
        System.out.println(colorTable.keys());;
        System.out.println(colorTable.values());;
        colorTable.set("maroon", "#800001");
        System.out.println("======");
        System.out.println(Arrays.toString(colorTable.get("maroon")));
        System.out.println(colorTable.keys());;
        System.out.println(colorTable.values());;
    }
}
