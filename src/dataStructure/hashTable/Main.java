package dataStructure.hashTable;

public class Main {
    public static void main(String[] args) {
        Hash hash = new Hash();
        /*System.out.println(hash.oldHash("pink", 10));
        System.out.println(hash.oldHash("orangered", 10));
        System.out.println(hash.oldHash("cyan", 10));*/
        System.out.println(hash.hash("hello", 13));
        System.out.println(hash.hash("goodbye", 13));
        System.out.println(hash.hash("cyan", 13));
    }
}
